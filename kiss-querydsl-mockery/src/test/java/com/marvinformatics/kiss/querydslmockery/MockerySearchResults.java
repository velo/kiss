package com.marvinformatics.kiss.querydslmockery;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPQLQuery;

public interface MockerySearchResults<E> {

	SearchResults<E> runQuery(JPQLQuery query);

	void matchResult(SearchResults<E> result);

}
