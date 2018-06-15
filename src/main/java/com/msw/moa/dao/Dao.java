package com.msw.moa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * DAOインターフェース
 * 
 * @author 王磊
 */
public interface Dao<T> {

	public void persist(T ent);

	public void merge(T ent);

	public void delete(T ent);

	public T findById(Serializable id);

	public List<T> findAll();

	public List<T> findAllByPriority();

	public List<T> findValid();

	public T getValid(Serializable id);

	List<T> findValidByPriority();

	public List<T> findByCriteria(DetachedCriteria criteria);
}
