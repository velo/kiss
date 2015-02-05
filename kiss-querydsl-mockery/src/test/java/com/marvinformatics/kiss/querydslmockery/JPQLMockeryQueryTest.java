package com.marvinformatics.kiss.querydslmockery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;

public class JPQLMockeryQueryTest extends AbstractJPQLMockeryQueryTest {

	@Override
	protected JPQLMockeryQuery createJPQLMockeryQuery() {
		return new JPQLMockeryQuery();
	}

	@Test
	public void singleResultTuple() {
		execute( new Mockery<Tuple>() {
			@Override
			public Tuple runQuery(JPQLQuery query) {
				return query.from( p ).where( p.id.eq( "3456" ) )
						.singleResult( p.name, p.child.size() );
			}

			@Override
			public void matchResult(Tuple result) {
				assertThat( result, notNullValue() );
				assertThat( result.get( p.name ), equalTo( "Pedro" ) );
				assertThat( result.get( p.child.size() ), equalTo( 1 ) );
			}
		} );
	}

	//
	// @Test
	// public void subquery() {
	// execute(new MockeryParameters<List<String>>() {
	// @Override
	// public List<String> runQuery(JPQLQuery query) {
	// return query.from(p)
	// .list(new JPASubQuery().from(a).unique(a.id));
	// }
	//
	// @Override
	// public void matchResult(List<String> result) {
	// assertThat(result, hasSize(4));
	// assertThat(result.get(0),
	// equalTo("42"));
	// assertThat(result.get(1),
	// equalTo("42"));
	// assertThat(result.get(2),
	// equalTo("42"));
	// assertThat(result.get(3),
	// equalTo("42"));
	// }
	// });
	// }
}
