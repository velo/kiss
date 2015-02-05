package com.marvinformatics.kiss.querydslmockery.evaluator;

import static com.marvinformatics.kiss.querydslmockery.evaluator.PathUtil.getValue;

import java.util.ArrayList;
import java.util.List;

import com.mysema.codegen.Evaluator;
import com.mysema.query.types.ArrayConstructorExpression;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathImpl;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.path.EntityPathBase;

public class ProjectionEvaluator implements Evaluator {

	private List<? extends Expression<?>> sources;
	private Expression projection;

	public ProjectionEvaluator(List<? extends Expression<?>> sources, Expression projection) {
		this.sources = sources;
		this.projection = projection;
	}

	@Override
	public Object evaluate(Object... args) {
		final Class sourceType = ((EntityPathBase) sources.get( 0 )).getType();

		if (projection instanceof EntityPathBase)
			return getArgByType( projection.getType(), args );

		if (projection instanceof SimpleExpression || projection instanceof PathImpl)
			return getValue( (Path) projection, getArgByType( ((Path) projection).getRoot().getType(), args ) );

		if (projection.getType().equals( Object[].class ))
			return complexProjection( args );

		return getArgByType( projection.getType(), args );
	}

	protected Object complexProjection(Object... args) {
		ArrayList<Object> projectionResult = new ArrayList<Object>();
		ArrayConstructorExpression arrayConstructorExpression = (ArrayConstructorExpression) projection;
		List argsExpression = arrayConstructorExpression.getArgs();

		for (Object object : argsExpression)
			projectionResult.add( getValue(
					(PathImpl<?>) ((java.util.Collection) argsExpression).iterator().next(),
					getArgByType( ((PathImpl) object).getRoot().getType(), args ) ) );
		return projectionResult.toArray();
	}

	protected Object getArgByType(Class type, Object... args) {
		for (Object arg : args)
			if (arg.getClass().equals( type ))
				return arg;
		return args[0];
	}

	@Override
	public Class getType() {
		return projection.getType();
	}
}
