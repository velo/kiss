package com.marvinformatics.kiss.querydslmockery.evaluator;

import java.util.List;

import com.mysema.codegen.Evaluator;
import com.mysema.codegen.model.ClassType;
import com.mysema.codegen.model.TypeCategory;
import com.mysema.query.QueryMetadata;
import com.mysema.query.collections.CollQueryTemplates;
import com.mysema.query.collections.DefaultEvaluatorFactory;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.PredicateOperation;

public class FastEvaluatorFactory extends DefaultEvaluatorFactory {

	private final CollQueryTemplates templates;

	public FastEvaluatorFactory(CollQueryTemplates templates) {
		super( templates, Thread.currentThread().getContextClassLoader() );
		this.templates = templates;
	}

	@Override
	public <T> Evaluator<List<T>> createEvaluator(QueryMetadata metadata, Expression<? extends T> source,
			Predicate filter) {
		ClassType type = new ClassType( TypeCategory.SIMPLE, source.getType() );
		return new BodyEvaluator( type, (PredicateOperation) filter, templates );
	}

	@Override
	public <T> Evaluator<T> create(QueryMetadata metadata, List<? extends
			Expression<?>> sources,
			Expression<T> projection) {
		return new ProjectionEvaluator( sources, projection );
	}
}
