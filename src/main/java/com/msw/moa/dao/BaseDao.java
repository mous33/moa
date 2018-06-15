package com.msw.moa.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.msw.moa.info.Constants.Code.ValidFlag;

/**
 * 基底DAO。
 * 
 * @author 王磊
 */
public class BaseDao<T> extends HibernateDaoSupport implements Dao<T> {

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * エンティティクラス。
	 */
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>)type.getActualTypeArguments()[0];
	}

	final Class<T> getEntityClass() {
		return this.entityClass;
	}

	@Override
	public void persist(T ent) {
		this.getHibernateTemplate().persist(ent);
	}

	@Override
	public void merge(T ent) {
		this.getHibernateTemplate().merge(ent);
	}

	@Override
	public void delete(T ent) {
		this.getHibernateTemplate().delete(ent);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(getEntityClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(getEntityClass());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAllByPriority() {
		DetachedCriteria c = getCriteria();
		c.addOrder(Order.asc("priority"));
		return (List<T>)this.getHibernateTemplate().findByCriteria(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findValid() {
		DetachedCriteria c = getCriteria();
		c.add(Property.forName("validFlag").eq(ValidFlag.VALID_YES));
		return (List<T>)this.getHibernateTemplate().findByCriteria(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findValidByPriority() {
		DetachedCriteria c = getCriteria();
		c.add(Property.forName("validFlag").eq(ValidFlag.VALID_YES));
		c.addOrder(Order.asc("priority"));
		return (List<T>)this.getHibernateTemplate().findByCriteria(c);
	}

	@Override
	public T getValid(Serializable id) {
		T ent = this.findById(id);
		if (ent != null) {
			Method m;
			try {
				m = entityClass.getDeclaredMethod("getValidFlag");
				Integer validFlag = (Integer)m.invoke(ent);
				return ValidFlag.VALID_YES.equals(validFlag) ? ent : null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ent;
	}

	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(this.entityClass, "e");
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return (List<T>)this.getHibernateTemplate().findByCriteria(criteria);
	}

}
