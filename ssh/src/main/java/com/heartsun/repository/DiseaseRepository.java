package com.heartsun.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.heartsun.entity.Disease;

@Repository
@SuppressWarnings("unchecked")
public class DiseaseRepository extends BaseRepository<Disease> implements IDiseaseRepository {

	@Override
	public List<Disease> queryNormals(List<String> diseaseIds) {
		String hql = "from Disease where common = 1 and id in (:id)";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameterList("id", diseaseIds);
		return query.list();
	}

	@Override
	public Integer queryNormalCount(List<Long> diseaseIds) {
		String hql = "select count(*) from Disease where common = 1 and id in (:id)";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameterList("id", diseaseIds);
		Object obj = query.uniqueResult();
		Integer count = -1;
		if(obj != null) {
			System.out.println("object =======" + obj.toString());
			count = Integer.parseInt(obj.toString());
		}
		return count;
	}

}
