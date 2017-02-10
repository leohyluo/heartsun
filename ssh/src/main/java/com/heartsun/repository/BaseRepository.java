package com.heartsun.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

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
		Query q = getCurrentSession().createQuery(hql);
		if(!CollectionUtils.isEmpty(params)) {
			for(String key : params.keySet()) {
				Object val = params.get(key);
				q.setParameter(key, val);
			}
		}
		return q.list();
	}
	

	@Override
	public List<T> find(T t) throws Exception {
		Class clazz = t.getClass();
		String className = clazz.getName();
		StringBuffer sb = new StringBuffer("from ").append(className).append(" where 1=1 ");
		Field[] fields = clazz.getDeclaredFields();
		List<Object> vals = new ArrayList<>();
		for(Field field : fields) {
			String fieldName = field.getName();
			String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method method = clazz.getMethod(methodName);
			Object val = method.invoke(t);
			if(val != null) {
				vals.add(val);
				sb.append("and ").append(fieldName).append(" = ?");
			}
		}
		Query q = getCurrentSession().createQuery(sb.toString());
		for(int i=0; i<vals.size(); i++) {
			q.setParameter(i, vals.get(i));
		}
		return q.list();
	}
	
	private <T> void setParameter(Query q, Map<String, Object> params) throws NoSuchFieldException, SecurityException {
		Class clazz = null;
		for(String key : params.keySet()) {
			Field field = clazz.getDeclaredField(key);
			Class typeClass = field.getType();
		}
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
