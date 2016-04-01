package com.marvinformatics.kiss.querydslmockery;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.marvinformatics.kiss.querydslmockery.evaluator.MockeryEvaluatorFactory;
import com.marvinformatics.kiss.querydslmockery.impl.AbstractQueryBase;
import com.marvinformatics.kiss.querydslmockery.impl.MockeryQueryTemplates;
import com.mysema.commons.lang.CloseableIterator;
import com.mysema.commons.lang.IteratorAdapter;
import com.querydsl.collections.CollQueryMixin;
import com.querydsl.collections.CollQuerySerializer;
import com.querydsl.collections.DefaultEvaluatorFactory;
import com.querydsl.collections.DefaultQueryEngine;
import com.querydsl.collections.QueryEngine;
import com.querydsl.core.DefaultQueryMetadata;
import com.querydsl.core.JoinType;
import com.querydsl.core.QueryMetadata;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.MapExpression;
import com.querydsl.core.types.Operator;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

/**
 * <p>
 * JPQLMockeryQuery class.
 * </p>
 *
 * @author Marvin
 * @since 0.8
 */
public class JPQLMockeryQuery<T> extends AbstractQueryBase<T, JPQLMockeryQuery<T>> {

  private static final long serialVersionUID = 4779907899645076561L;

  private final Map<Expression<?>, Iterable<?>> iterables = new HashMap<Expression<?>, Iterable<?>>();

	private final QueryEngine queryEngine;

	/**
	 * <p>
	 * Constructor for JPQLMockeryQuery.
	 * </p>
	 */
	public JPQLMockeryQuery() {
		this( new DefaultEvaluatorFactory( MockeryQueryTemplates.DEFAULT, MockeryEvaluatorFactory.DEFAULT ) );
	}

	public JPQLMockeryQuery(DefaultEvaluatorFactory evaluatorFactory) {
		this( new CollQueryMixin<JPQLMockeryQuery<T>>( new DefaultQueryMetadata() ),
				new DefaultQueryEngine( evaluatorFactory ) );
		try {
			clearSerializerOperators();
		} catch (Exception e) {
			throw new RuntimeException( e );
		}
		this.queryMixin.setSelf( this );
	}

    protected void clearSerializerOperators() throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = CollQuerySerializer.class
                .getDeclaredField( "OPERATOR_SYMBOLS" );
        field.setAccessible( true );
        @SuppressWarnings("unchecked")
        Map<Operator, String> OPERATOR_SYMBOLS = (Map<Operator, String>) field
                .get( null );
        OPERATOR_SYMBOLS.clear();
    }

	/**
	 * <p>
	 * Constructor for JPQLMockeryQuery.
	 * </p>
	 */
	public JPQLMockeryQuery(CollQueryMixin<JPQLMockeryQuery<T>> queryMixin,
			QueryEngine queryEngine) {
		super( queryMixin );
		this.queryEngine = queryEngine;
	}

	/**
	 * <p>
	 * bind
	 * </p>
	 */
	public <A> JPQLMockeryQuery<T> bind(Path<A> entity, Iterable<? extends A> col) {
		iterables.put( entity, col );
		queryMixin.getMetadata().addJoin( JoinType.DEFAULT, entity );
		return this;
	}


	/** {@inheritDoc} */
	@Override
	public long fetchCount() {
		try {
			return queryEngine.count( queryMixin.getMetadata(), iterables );
		} finally {
			reset();
		}
	}

	/** {@inheritDoc} */
	@Override
	public JPQLMockeryQuery<T> from(EntityPath<?>... sources) {
      return queryMixin.from(sources);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(CollectionExpression<?, P> target) {
	  return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(CollectionExpression<?, P> target, Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(EntityPath<P> target) {
      return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(EntityPath<P> target, Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(MapExpression<?, P> target) {
      return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> join(MapExpression<?, P> target, Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(CollectionExpression<?, P> target) {
      return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(EntityPath<P> target) {
      return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(EntityPath<P> target, Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(MapExpression<?, P> target) {
      return queryMixin.innerJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> innerJoin(MapExpression<?, P> target, Path<P> alias) {
      return queryMixin.innerJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
      return queryMixin.leftJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(CollectionExpression<?, P> target) {
      return queryMixin.leftJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(EntityPath<P> target) {
      return queryMixin.leftJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(EntityPath<P> target, Path<P> alias) {
      return queryMixin.leftJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(MapExpression<?, P> target) {
      return queryMixin.leftJoin(target);
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLMockeryQuery<T> leftJoin(MapExpression<?, P> target, Path<P> alias) {
      return queryMixin.leftJoin(target, alias);
	}

	/** {@inheritDoc} */
	@Override
	public BooleanExpression notExists() {
		return exists().not();
	}

	private void reset() {
		queryMixin.getMetadata().reset();
	}

    @SuppressWarnings("unchecked")
    @Override
    public JPQLMockeryQuery<Tuple> select(Expression<?>... exprs) {
        queryMixin.setProjection(exprs);
        return (JPQLMockeryQuery<Tuple>) queryMixin.getSelf();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> JPQLMockeryQuery<U> select(Expression<U> expr)
    {
        queryMixin.setProjection(expr);
        return (JPQLMockeryQuery<U>) queryMixin.getSelf();
    }

    @Override
    public T fetchOne()
    {
      queryMixin.setUnique(true);
      if (queryMixin.getMetadata().getModifiers().getLimit() == null) {
          limit(2L);
      }
      return uniqueResult(iterate());
    }

    @Override
    public CloseableIterator<T> iterate()
    {
      @SuppressWarnings("unchecked")
      Expression<T> projection = (Expression<T>) queryMixin.getMetadata().getProjection();
      return new IteratorAdapter<T>(queryEngine.list(getMetadata(), iterables, projection).iterator());
    }

    @Override
    public QueryMetadata getMetadata()
    {
      return queryMixin.getMetadata();
    }

    @Override
    public QueryResults<T> fetchResults()
    {
      @SuppressWarnings("unchecked")
      Expression<T> projection = (Expression<T>) queryMixin.getMetadata().getProjection();
      long count = queryEngine.count(getMetadata(), iterables);
      if (count > 0L) {
          List<T> list = queryEngine.list(getMetadata(), iterables, projection);
          return new QueryResults<T>(list, getMetadata().getModifiers(), count);
      } else {
          return QueryResults.<T>emptyResults();
      }
    }

}
