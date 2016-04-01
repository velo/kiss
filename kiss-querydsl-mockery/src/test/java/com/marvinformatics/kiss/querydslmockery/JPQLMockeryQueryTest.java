package com.marvinformatics.kiss.querydslmockery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import com.marvinformatics.kiss.querydslmockery.entity.Person;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

public class JPQLMockeryQueryTest extends AbstractJPQLMockeryQueryTest {

	@Override
	protected JPQLMockeryQuery<Person> createJPQLMockeryQuery() {
		return new JPQLMockeryQuery<Person>();
	}

	@Test
	public void singleResultTuple() {
		execute( new Mockery<Tuple, Person>() {
			@Override
			public Tuple runQuery(JPQLQuery<Person> query) {
				return query
    				    .select( p.name, p.child.size() )
    				    .from( p )
    				    .where( p.id.eq( "3456" ) )
						.fetchOne();
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
