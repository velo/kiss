package com.marvinformatics.kiss.querydslmockery;

import com.mysema.query.jpa.JPQLQuery;

public interface Mockery<E> {

	E runQuery(JPQLQuery query);

	void matchResult(E result);

}
