package com.marvinformatics.kiss.querydslmockery.impl;

import java.util.List;
import java.util.Map;

import com.marvinformatics.kiss.querydslmockery.JPQLMockeryQuery;
import com.mysema.commons.lang.CloseableIterator;
import com.mysema.query.ResultTransformer;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.support.QueryBase;
import com.mysema.query.support.QueryMixin;
import com.mysema.query.types.CollectionExpression;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Expression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;

/**
 *
 * This class hosts no real code, it is only here to make
 * {@link JPQLMockeryQuery} cleaner and more pleasant to read.
 *
 * As thumb rule shall not be changed!
 *
 * @author Marvin
 * @since 0.8
 */
public abstract class AbstractQueryBase<Q extends QueryBase<Q> & JPQLQuery>
		extends QueryBase<Q> implements JPQLQuery {

	/**
	 * <p>Constructor for AbstractQueryBase.</p>
	 */
	public AbstractQueryBase(QueryMixin<Q> queryMixin) {
		super(queryMixin);
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery from(EntityPath<?>... sources) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(CollectionExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(EntityPath<P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(CollectionExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(CollectionExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(CollectionExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(EntityPath<P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(CollectionExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery rightJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(EntityPath<P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(CollectionExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(CollectionExpression<?, P> target,
			Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <P> JPQLQuery fullJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery on(Predicate... condition) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public long count() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public boolean notExists() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public CloseableIterator<Tuple> iterate(Expression<?>... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <RT> CloseableIterator<RT> iterate(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public List<Tuple> list(Expression<?>... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <RT> List<RT> list(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public SearchResults<Tuple> listResults(Expression<?>... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <RT> SearchResults<RT> listResults(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <K, V> Map<K, V> map(Expression<K> key, Expression<V> value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public Tuple singleResult(Expression<?>... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <RT> RT singleResult(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <T> T transform(ResultTransformer<T> transformer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public Tuple uniqueResult(Expression<?>... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <RT> RT uniqueResult(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery fetch() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public JPQLQuery fetchAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
