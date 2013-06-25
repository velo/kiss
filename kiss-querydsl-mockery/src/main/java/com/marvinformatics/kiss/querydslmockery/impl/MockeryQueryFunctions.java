package com.marvinformatics.kiss.querydslmockery.impl;

import java.util.Collection;

import com.mysema.query.collections.CollQueryFunctions;

/**
 * <p>
 * MockeryQueryFunctions class.
 * </p>
 * 
 * @author Marvin
 * @since 0.8
 */
public class MockeryQueryFunctions {

	/**
	 * <p>
	 * equals
	 * </p>
	 * 
	 * @since 0.8
	 */
	public static boolean equals(Object o1, Object o2) {
		if (o1 == o2)
			return true;

		if (o1 == null)
			return false;

		if (o2 == null)
			return false;

		return o1.equals(o2);
	}

	public static String toLowerCase(String text) {
		if (text == null)
			return null;

		return text.toLowerCase();
	}

	public static boolean like(final String str, String like) {
		if (str == null)
			return false;

		return CollQueryFunctions.like(str, like);
	}

	public static boolean like(String str, String like, char escape) {
		return like(str, like);
	}

	public static <E> boolean in(Collection<E> col, E filter) {
		if (col.isEmpty() && filter == null)
			return true;

		return col.contains(filter);
	}

}
