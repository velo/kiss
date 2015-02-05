package com.marvinformatics.kiss.querydslmockery;

import com.marvinformatics.kiss.querydslmockery.evaluator.FastEvaluatorFactory;
import com.marvinformatics.kiss.querydslmockery.impl.MockeryQueryTemplates;

public class FastJPQLMockeryQuery extends JPQLMockeryQuery {

	public FastJPQLMockeryQuery() {
		super( new FastEvaluatorFactory( MockeryQueryTemplates.DEFAULT ) );
	}

}
