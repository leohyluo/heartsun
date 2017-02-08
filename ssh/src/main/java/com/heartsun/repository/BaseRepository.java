package com.heartsun.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("all")
public class BaseRepository<T> implements IBaseRepository<T> {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(T o) {
		// TODO Auto-generated method stub
		
	}

	public void update(T o) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	public T get(String hql) {
		return null;
	}

	public T get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

}
