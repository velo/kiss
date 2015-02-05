package com.marvinformatics.kiss.querydslmockery;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.marvinformatics.kiss.querydslmockery.impl.AbstractQueryBase;
import com.marvinformatics.kiss.querydslmockery.impl.MockeryQueryTemplates;
import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.JoinType;
import com.mysema.query.NonUniqueResultException;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.collections.CollQueryMixin;
import com.mysema.query.collections.CollQuerySerializer;
import com.mysema.query.collections.DefaultEvaluatorFactory;
import com.mysema.query.collections.DefaultQueryEngine;
import com.mysema.query.collections.QueryEngine;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.CollectionExpression;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Expression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.Operator;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.QTuple;

/**
 * <p>
 * JPQLMockeryQuery class.
 * </p>
 *
 * @author Marvin
 * @since 0.8
 */
public class JPQLMockeryQuery extends AbstractQueryBase<JPQLMockeryQuery> {

	private final Map<Expression<?>, Iterable<?>> iterables = new HashMap<Expression<?>, Iterable<?>>();

	private final QueryEngine queryEngine;

	/**
	 * <p>
	 * Constructor for JPQLMockeryQuery.
	 * </p>
	 */
	public JPQLMockeryQuery() {
		this( new DefaultEvaluatorFactory( MockeryQueryTemplates.DEFAULT ) );
	}

	public JPQLMockeryQuery(DefaultEvaluatorFactory evaluatorFactory) {
		this( new CollQueryMixin<JPQLMockeryQuery>( new DefaultQueryMetadata() ),
				new DefaultQueryEngine( evaluatorFactory ) );
		try {
			clearSerializerOperators();
		} catch (Exception e) {
			throw new RuntimeException( e );
		}
		this.queryMixin.setSelf( this );
	}

	/**
	 * <p>
	 * Constructor for JPQLMockeryQuery.
	 * </p>
	 */
	public JPQLMockeryQuery(CollQueryMixin<JPQLMockeryQuery> queryMixin,
			QueryEngine queryEngine) {
		super( queryMixin );
		this.queryEngine = queryEngine;
	}

	/**
	 * <p>
	 * bind
	 * </p>
	 */
	public <A> JPQLMockeryQuery bind(Path<A> entity, Iterable<? extends A> col) {
		iterables.put( entity, col );
		queryMixin.getMetadata().addJoin( JoinType.DEFAULT, entity );
		return this;
	}

	protected void clearSerializerOperators() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = CollQuerySerializer.class
				.getDeclaredField( "OPERATOR_SYMBOLS" );
		field.setAccessible( true );
		@SuppressWarnings("unchecked")
		Map<Operator<?>, String> OPERATOR_SYMBOLS = (Map<Operator<?>, String>) field
				.get( null );
		OPERATOR_SYMBOLS.clear();
	}

	/** {@inheritDoc} */
	@Override
	public long count() {
		try {
			return queryEngine.count( queryMixin.getMetadata(), iterables );
		} finally {
			reset();
		}
	}

	/** {@inheritDoc} */
	@Override
	public boolean exists() {
		try {
			return queryEngine.exists( queryMixin.getMetadata(), iterables );
		} finally {
			reset();
		}
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery fetch() {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery from(EntityPath<?>... sources) {
		// seem to be the most reasonable thing to do
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(CollectionExpression<?, P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(CollectionExpression<?, P> target, Path<P> alias) {
		queryMixin.innerJoin( target, alias );
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(EntityPath<P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(EntityPath<P> target, Path<P> alias) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target, Path<P> alias) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(CollectionExpression<?, P> target) {
		return join( target );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		return join( target, alias );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target) {
		return join( target );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target, Path<P> alias) {
		return join( target, alias );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target) {
		return join( target );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target, Path<P> alias) {
		return join( target, alias );
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		queryMixin.leftJoin( target, alias );
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(CollectionExpression<?, P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target, Path<P> alias) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target, Path<P> alias) {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public <RT> List<RT> list(Expression<RT> projection) {
		try {
			projection = queryMixin.convert( projection, true );
			queryMixin.addProjection( projection );
			return queryEngine.list( queryMixin.getMetadata(), iterables,
					projection );
		} finally {
			reset();
		}
	}

	/** {@inheritDoc} */
	@Override
	public boolean notExists() {
		return !exists();
	}

	private void reset() {
		queryMixin.getMetadata().reset();
	}

	/** {@inheritDoc} */
	@Override
	public Tuple singleResult(Expression<?>... args) {
		return limit( 1 ).uniqueResult( args );
	}

	/** {@inheritDoc} */
	@Override
	public <RT> RT singleResult(Expression<RT> projection) {
		return limit( 1 ).uniqueResult( projection );
	}

	/** {@inheritDoc} */
	@Override
	public Tuple uniqueResult(Expression<?>... args) {
		return uniqueResult( new QTuple( args ) );
	}

	/** {@inheritDoc} */
	@Override
	public <RT> RT uniqueResult(Expression<RT> projection) {
		try {
			List<RT> resultSet = list( projection );

			if (resultSet.isEmpty())
				return null;

			if (resultSet.size() != 1)
				throw new NonUniqueResultException();

			return resultSet.get( 0 );
		} finally {
			reset();
		}
	}

	/** {@inheritDoc} */
	@Override
	public JPQLMockeryQuery where(Predicate... o) {
		return super.where( o );
	}

	/** {@inheritDoc} */
	@Override
	public <RT> SearchResults<RT> listResults(Expression<RT> projection) {
		try {
			projection = queryMixin.convert( projection, true );
			queryMixin.addProjection( projection );
			List<RT> result = queryEngine.list( queryMixin.getMetadata(),
					iterables, projection );
			return new SearchResults<RT>( result, queryMixin.getMetadata()
					.getModifiers(), this.count() );
		} finally {
			reset();
		}
	}

}
