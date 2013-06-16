package com.marvinformatics.kiss.querydslmockery.impl;

import com.mysema.query.collections.CollQueryTemplates;
import com.mysema.query.types.Ops;

/**
 * @author Marvin
 */
public class MockeryQueryTemplates extends CollQueryTemplates {

	public static final MockeryQueryTemplates DEFAULT = new MockeryQueryTemplates();

	protected MockeryQueryTemplates() {
		super();

		String functions = MockeryQueryFunctions.class.getName();
		add(Ops.EQ, functions + ".equals({0}, {1})");
		add(Ops.NE, "!" + functions + ".equals({0}, {1})");
	}

}
