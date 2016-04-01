package com.marvinformatics.kiss.querydslmockery.impl;

import com.querydsl.collections.CollQueryTemplates;
import com.querydsl.core.types.Ops;

/**
 * <p>MockeryQueryTemplates class.</p>
 *
 * @author Marvin
 * @since 0.8
 */
public class MockeryQueryTemplates extends CollQueryTemplates {

	/** Constant <code>DEFAULT</code> */
	public static final MockeryQueryTemplates DEFAULT = new MockeryQueryTemplates();

	protected MockeryQueryTemplates() {
		super();

		String functions = MockeryQueryFunctions.class.getName();
		add(Ops.EQ, functions + ".equals({0}, {1})");
		add(Ops.NE, "!" + functions + ".equals({0}, {1})");
        add(Ops.LOWER, functions + ".toLowerCase({0})");
        add(Ops.LIKE, functions + ".like({0},{1})");
        add(Ops.IN, functions + ".in({1},{0})");
	}

}
