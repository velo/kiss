package com.marvinformatics.kiss.querydslmockery.evaluator;

import static com.marvinformatics.kiss.querydslmockery.evaluator.PathUtil.getValue;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.script.ScriptException;

import com.marvinformatics.kiss.querydslmockery.engine.ScriptEngineEval;
import com.mysema.codegen.Evaluator;
import com.mysema.codegen.model.ClassType;
import com.mysema.query.collections.CollQueryTemplates;
import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Operation;
import com.mysema.query.types.OperationImpl;
import com.mysema.query.types.Operator;
import com.mysema.query.types.Ops;
import com.mysema.query.types.PathImpl;
import com.mysema.query.types.PredicateOperation;
import com.mysema.query.types.Template.Element;

public class BodyEvaluator implements Evaluator {

	private ClassType type;
	private PredicateOperation filter;
	private CollQueryTemplates templates;

	public BodyEvaluator(ClassType type, PredicateOperation filter, CollQueryTemplates templates) {
		this.type = type;
		this.filter = filter;
		this.templates = templates;
	}

	@Override
	public Object evaluate(Object... args) {
		Iterable<?> iterableWtf = (Iterable<?>) args[0];
		ArrayList<Object> values = new ArrayList<Object>();
		for (Object tuple : iterableWtf)
			try {
				if (match( filter, tuple ))
					values.add( tuple );
			} catch (Exception e) {
				throw new RuntimeException( e );
			}

		return values;
	}

	private boolean match(OperationImpl filter, Object tuple) throws ScriptException {
		if (isLeaf( filter ))
			return evalOperator( tuple, filter );
		else
			return evalOperator( filter.getOperator(), match( (OperationImpl) filter.getArg( 0 ), tuple ),
					match( (OperationImpl) filter.getArg( 1 ), tuple ) );
	}

	private boolean evalOperator(Object tuple, Operation filter) throws ScriptException {
		ArrayList<Object> args = new ArrayList<Object>();

		for (Object expression : filter.getArgs())
			if (expression instanceof PathImpl)
				args.add( getValue( (PathImpl) expression, tuple ) );
			else
				args.add( ((ConstantImpl) expression).getConstant() );

		return evalOperator( filter.getOperator(), args.toArray() );
	}

	protected boolean evalOperator(Operator operator, Object... values) throws ScriptException {
		if (Ops.OR == operator)
			return (Boolean) values[0] || (Boolean) values[1];
		if (Ops.AND == operator)
			return (Boolean) values[0] && (Boolean) values[1];

		String methodTemplate = templates.getTemplate( operator ).toString();
		return invokeOperator( methodTemplate, values );
	}

	protected boolean invokeOperator(String methodTemplate, Object... values) throws ScriptException {
		prepareParameters( values );
		return (Boolean) ScriptEngineEval.eval( MessageFormat.format( methodTemplate.replaceAll( "l}", "}" ), values ) );
	}

	protected void prepareParameters(Object... values) {
		for (int i = 0; i < values.length; i++)
			if (values[i] != null) {
				if (values[i] instanceof String || values[i].getClass().isEnum()
						|| values[i].getClass().isAnnotationPresent( Entity.class ))
					values[i] = "'" + values[i] + "'";
				if (values[i] instanceof Date)
					values[i] = "new java.util.Date(" + ((Date) values[i]).getTime() + ")";
				if (values[i] instanceof Number)
					values[i] = values[i].toString();
			}
	}

	protected boolean invokeOperator(Operator operator, String clazz, String methodName, Object... values)
			throws ReflectiveOperationException, ScriptException {
		Object result = executeMethod( clazz, methodName, values );

		if (result instanceof Integer) {
			List<Element> templateElements = templates.getTemplate( operator ).getElements();
			String statement = result.toString()
					+ templateElements.get( templateElements.size() - 1 ).toString().substring( 2 );
			return (Boolean) ScriptEngineEval.eval( statement.substring( 0, statement.length() - 1 ) );
		} else
			return (Boolean) result;
	}

	protected Object executeMethod(String clazz, String methodName, Object... values)
			throws ReflectiveOperationException {
		Method[] declaredMethods = Class.forName( clazz ).getDeclaredMethods();
		for (Method method : declaredMethods)
			if (methodName.equalsIgnoreCase( method.getName() ))
				return method.invoke( null, values );
		throw new ReflectiveOperationException( methodName + " not found" );
	}

	protected boolean isLeaf(Operation filter) {
		return filter.getArg( 0 ) instanceof PathImpl;
	}

	@Override
	public Class getType() {
		return type.getJavaClass();
	}
}
