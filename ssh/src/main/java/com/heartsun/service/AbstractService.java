package com.heartsun.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heartsun.repository.BaseRepository;

@Transactional
public abstract class AbstractService<T> implements BaseService<T> {
	
	public abstract BaseRepository<T> getRepository();

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Serializable save(T o) {
		return getRepository().save(o);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(T o) {
		getRepository().delete(o);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(T o) {
		getRepository().update(o);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveOrUpdate(T o) {
		getRepository().saveOrUpdate(o);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public T get(String hql) {
		return getRepository().get(hql);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public T get(String hql, Map<String, Object> params) {
		return getRepository().get(hql, params);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> get(T t) throws Exception {
		return getRepository().find(t);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> find(String hql) {
		return getRepository().find(hql);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> find(String hql, Map<String, Object> params) {
		return getRepository().find(hql, params);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> find(String hql, int page, int rows) {
		return getRepository().find(hql, page, rows);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		return getRepository().find(hql, params, page, rows);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Long count(String hql) {
		return getRepository().count(hql);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Long count(String hql, Map<String, Object> params) {
		return getRepository().count(hql, params);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public T get(Class<T> c, Serializable id) {
		return getRepository().get(c, id);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public int executeHql(String hql) {
		return getRepository().executeHql(hql);
	}

}
