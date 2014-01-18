package com.marvinformatics.kiss.querydslmockery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.marvinformatics.kiss.querydslmockery.entity.Address;
import com.marvinformatics.kiss.querydslmockery.entity.PeopleLocation;
import com.marvinformatics.kiss.querydslmockery.entity.Person;
import com.marvinformatics.kiss.querydslmockery.entity.QAddress;
import com.marvinformatics.kiss.querydslmockery.entity.QPeopleLocation;
import com.marvinformatics.kiss.querydslmockery.entity.QPerson;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPASubQuery;
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

	@BeforeSuite
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
		execute(new MockeryParameters<Long>() {
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

	private <E> void execute(MockeryParameters<E> mockeryParameters) {
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

	@Test
	public void exists() {
		execute(new MockeryParameters<Boolean>() {
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
		execute(new MockeryParameters<List<Person>>() {
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
		execute(new MockeryParameters<List<Person>>() {
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
	public void noMatchCondition() {
		execute(new MockeryParameters<List<Person>>() {
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
		execute(new MockeryParameters<Boolean>() {
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
		execute(new MockeryParameters<List<String>>() {
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
		execute(new MockeryParameters<String>() {
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
	public void singleResultNonUniqueResult() {
		execute(new MockeryParameters<String>() {
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
		execute(new MockeryParameters<Person>() {
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
		execute(new MockeryParameters<Tuple>() {
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

	@Test(expectedExceptions = NonUniqueResultException.class)
	public void uniqueResultNonUniqueResult() {
		JPQLMockeryQuery mq = new JPQLMockeryQuery();
		mq.bind(p, people);
		mq.from(p).uniqueResult(p);
	}

	@Test
	public void where() {
		execute(new MockeryParameters<List<Person>>() {
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
//
//	@Test
//	public void leftJoin() {
//		execute(new MockeryParameters<List<PeopleLocation>>() {
//			@Override
//			public List<PeopleLocation> runQuery(JPQLQuery query) {
//				return query.from(p).leftJoin(p.address, a).orderBy(p.id.asc())
//						.list(new QPeopleLocation(p.name, a.city));
//			}
//
//			@Override
//			public void matchResult(List<PeopleLocation> result) {
//				MatcherAssert.assertThat(result, Matchers.hasSize(4));
//				MatcherAssert.assertThat(result.get(0).getCity(),
//						Matchers.nullValue());
//				MatcherAssert.assertThat(result.get(1).getCity(),
//						Matchers.notNullValue());
//				MatcherAssert.assertThat(result.get(2).getCity(),
//						Matchers.nullValue());
//				MatcherAssert.assertThat(result.get(3).getCity(),
//						Matchers.nullValue());
//			}
//		});
//	}
//	
//	@Test
//	public void subquery() {
//		execute(new MockeryParameters<List<String>>() {
//			@Override
//			public List<String> runQuery(JPQLQuery query) {
//				return query.from(p)
//						.list(new JPASubQuery().from(a).unique(a.id));
//			}
//			
//			@Override
//			public void matchResult(List<String> result) {
//				MatcherAssert.assertThat(result, Matchers.hasSize(4));
//				MatcherAssert.assertThat(result.get(0),
//						Matchers.equalTo("42"));
//				MatcherAssert.assertThat(result.get(1),
//						Matchers.equalTo("42"));
//				MatcherAssert.assertThat(result.get(2),
//						Matchers.equalTo("42"));
//				MatcherAssert.assertThat(result.get(3),
//						Matchers.equalTo("42"));
//			}
//		});
//	}
}
