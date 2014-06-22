package com.marvinformatics.kiss.querydslmockery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.marvinformatics.kiss.querydslmockery.entity.Address;
import com.marvinformatics.kiss.querydslmockery.entity.Person;
import com.marvinformatics.kiss.querydslmockery.entity.QAddress;
import com.marvinformatics.kiss.querydslmockery.entity.QPerson;
import com.mysema.query.NonUniqueResultException;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

public class JPQLMockeryQueryTest {

	private static EntityManager em;

	private static EntityManagerFactory factory;

	private static final Address a1 = new Address("42", "10 5th avenue", "city");
	private static final Person p1 = new Person("1234", "Juka");
	private static final Person p2 = new Person("2345", "Marko", a1, p1);
	private static final Person p3 = new Person("3456", "Pedro", p1);

	private static final Person p4 = new Person("4567", "Barca", p2, p3);
	private static List<Person> people;

	private static ArrayList<Address> addresses;

	@BeforeClass
	public static void checkClasses() {
		Person.class.getClass();
		QPerson.class.getClass();
	}

	@BeforeClass
	public static void goOn() {
		factory = Persistence.createEntityManagerFactory("h2");
		em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(a1);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		t.commit();

		people = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4));
		addresses = new ArrayList<Address>(Arrays.asList(a1));
	}

	@AfterClass
	public static void tearAppart() {
		em.close();
		factory.close();
		people.clear();
	}

	QPerson p = QPerson.person;
	QAddress a = QAddress.address;

	@Test
	public void count() {
		execute(new Mockery<Long>() {
			@Override
			public Long runQuery(JPQLQuery query) {
				return query.from(p).where(p.child.size().eq(2)).count();
			}

			@Override
			public void matchResult(Long result) {
				MatcherAssert.assertThat(result, Matchers.equalTo(1L));
			}
		});
	}

	private <E> void execute(Mockery<E> mockeryParameters) {
		JPAQuery regularQuery = new JPAQuery(em);
		E regularQueryResult = mockeryParameters.runQuery(regularQuery);
		mockeryParameters.matchResult(regularQueryResult);

		JPQLMockeryQuery mockedQuery = new JPQLMockeryQuery();
		mockedQuery.bind(p, people);
		mockedQuery.bind(a, addresses);
		E mockedQueryResult = mockeryParameters.runQuery(mockedQuery);
		mockeryParameters.matchResult(mockedQueryResult);

		MatcherAssert.assertThat(regularQueryResult,
				Matchers.equalTo(mockedQueryResult));
	}

	private <E> void execute(MockerySearchResults<E> mockery) {
		JPAQuery regularQuery = new JPAQuery(em);
		SearchResults<E> regularQueryResult = mockery.runQuery(regularQuery);
		mockery.matchResult(regularQueryResult);

		JPQLMockeryQuery mockedQuery = new JPQLMockeryQuery();
		mockedQuery.bind(p, people);
		mockedQuery.bind(a, addresses);
		SearchResults<E> mockedQueryResult = mockery.runQuery(mockedQuery);
		mockery.matchResult(mockedQueryResult);

		MatcherAssert.assertThat(regularQueryResult.getResults(),
				Matchers.equalTo(mockedQueryResult.getResults()));
	}

	@Test
	public void exists() {
		execute(new Mockery<Boolean>() {
			@Override
			public Boolean runQuery(JPQLQuery query) {
				return query.from(p).where(p.age.eq(1L)).exists();
			}

			@Override
			public void matchResult(Boolean result) {
				MatcherAssert.assertThat(result, Matchers.equalTo(false));
			}
		});
	}

	@Test
	public void from() {
		execute(new Mockery<List<Person>>() {
			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(4));
			}
		});
	}

	@Test
	public void join() {
		execute(new Mockery<List<Person>>() {
			QPerson c = new QPerson("child");

			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).join(p.child, c).where(c.name.eq("Juka"))
						.list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(2));
			}
		});
	}

	@Test
	public void innerJoin() {
		execute(new Mockery<List<Person>>() {
			QPerson c = new QPerson("child");

			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).innerJoin(p.child, c)
						.where(c.name.eq("Juka")).list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(2));
			}
		});
	}

	@Test
	public void noMatchCondition() {
		execute(new Mockery<List<Person>>() {
			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).where(p.name.eq("bananas")).list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(0));
			}
		});
	}

	@Test
	public void notExists() {
		execute(new Mockery<Boolean>() {
			@Override
			public Boolean runQuery(JPQLQuery query) {
				return query.from(p).where(p.age.eq(1L)).notExists();
			}

			@Override
			public void matchResult(Boolean result) {
				MatcherAssert.assertThat(result, Matchers.equalTo(true));
			}
		});
	}

	@Test
	public void orderBy() {
		execute(new Mockery<List<String>>() {
			@Override
			public List<String> runQuery(JPQLQuery query) {
				return query.from(p).orderBy(p.name.asc()).list(p.id);
			}

			@Override
			public void matchResult(List<String> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(4));
			}
		});
	}

	@Test
	public void singleResult() {
		execute(new Mockery<String>() {
			@Override
			public String runQuery(JPQLQuery query) {
				return query.from(p).where(p.id.eq("3456"))
						.singleResult(p.name);
			}

			@Override
			public void matchResult(String result) {
				MatcherAssert.assertThat(result, Matchers.equalTo("Pedro"));
			}
		});
	}

	@Test
	public void listResults() {
		execute(new MockerySearchResults<String>() {
			@Override
			public SearchResults<String> runQuery(JPQLQuery query) {
				return query.from(p).offset(2).limit(1).listResults(p.name);
			}

			@Override
			public void matchResult(SearchResults<String> result) {
				MatcherAssert.assertThat(result.getTotal(),
						Matchers.equalTo(4L));
				MatcherAssert.assertThat(result.getLimit(),
						Matchers.equalTo(1L));
				MatcherAssert.assertThat(result.getOffset(),
						Matchers.equalTo(2L));
			}
		});
	}

	@Test
	public void singleResultNonUniqueResult() {
		execute(new Mockery<String>() {
			@Override
			public String runQuery(JPQLQuery query) {
				return query.from(p).singleResult(p.name);
			}

			@Override
			public void matchResult(String result) {
				MatcherAssert.assertThat(result, Matchers.equalTo("Juka"));
			}
		});
	}

	@Test
	public void singleResultNoResult() {
		execute(new Mockery<Person>() {
			@Override
			public Person runQuery(JPQLQuery query) {
				return query.from(p).where(p.id.eq("42L")).singleResult(p);
			}

			@Override
			public void matchResult(Person result) {
				MatcherAssert.assertThat(result, Matchers.nullValue());
			}
		});
	}

	@Test
	public void singleResultTuple() {
		execute(new Mockery<Tuple>() {
			@Override
			public Tuple runQuery(JPQLQuery query) {
				return query.from(p).where(p.id.eq("3456"))
						.singleResult(p.name, p.child.size());
			}

			@Override
			public void matchResult(Tuple result) {
				MatcherAssert.assertThat(result, Matchers.notNullValue());
				MatcherAssert.assertThat(result.get(p.name),
						Matchers.equalTo("Pedro"));
				MatcherAssert.assertThat(result.get(p.child.size()),
						Matchers.equalTo(1));
			}
		});
	}

	@Test(expected = NonUniqueResultException.class)
	public void uniqueResultNonUniqueResult() {
		JPQLMockeryQuery mq = new JPQLMockeryQuery();
		mq.bind(p, people);
		mq.from(p).uniqueResult(p);
	}

	@Test
	public void where() {
		execute(new Mockery<List<Person>>() {
			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).where(p.name.like("%a%")).list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				MatcherAssert.assertThat(result, Matchers.hasSize(3));
			}
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void inEmptyListShouldFail() throws Exception {
		execute(new Mockery<List<Person>>() {

			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).where(p.id.in(new ArrayList<String>()))
						.list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
			}
		});
	}

	@Test
	public void leftJoin() {
		execute(new Mockery<List<Person>>() {
			@Override
			public List<Person> runQuery(JPQLQuery query) {
				return query.from(p).leftJoin(p.address, a).orderBy(p.id.asc())
						.list(p);
			}

			@Override
			public void matchResult(List<Person> result) {
				assertThat(result, hasSize(4));
				assertThat(result.get(1).getAddress(), is(notNullValue()));
				assertThat(result.get(1).getAddress(), equalTo(a1));
			}
		});
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
	// MatcherAssert.assertThat(result, Matchers.hasSize(4));
	// MatcherAssert.assertThat(result.get(0),
	// Matchers.equalTo("42"));
	// MatcherAssert.assertThat(result.get(1),
	// Matchers.equalTo("42"));
	// MatcherAssert.assertThat(result.get(2),
	// Matchers.equalTo("42"));
	// MatcherAssert.assertThat(result.get(3),
	// Matchers.equalTo("42"));
	// }
	// });
	// }
}
