package com.marvinformatics.kiss.querydslmockery;

import com.marvinformatics.kiss.querydslmockery.evaluator.FastEvaluatorFactory;
import com.marvinformatics.kiss.querydslmockery.impl.MockeryQueryTemplates;
import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.collections.CollQueryMixin;
import com.mysema.query.collections.DefaultQueryEngine;

public class FastJPQLMockeryQuery extends JPQLMockeryQuery {

	public FastJPQLMockeryQuery() {
		super( new CollQueryMixin<JPQLMockeryQuery>( new DefaultQueryMetadata() ),
				new DefaultQueryEngine( new FastEvaluatorFactory(
						MockeryQueryTemplates.DEFAULT ) ) );

		try {
			clearSerializerOperators();
		} catch (Exception e) {
			throw new RuntimeException( e );
		}
		this.queryMixin.setSelf( this );
	}

}
