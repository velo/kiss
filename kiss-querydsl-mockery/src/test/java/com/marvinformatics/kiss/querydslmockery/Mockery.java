package com.marvinformatics.kiss.querydslmockery;

import com.querydsl.jpa.JPQLQuery;

public interface Mockery<E, X> {

	E runQuery(JPQLQuery<X> query);

	void matchResult(E result);

}
