package com.heartsun.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heartsun.entity.BodyMainSymptom;

@Repository
public class BodyMainSymptomRepository extends BaseRepository<BodyMainSymptom> implements IBodyMainSymptomRepository {

	@Override
	public List<BodyMainSymptom> queryByBody(String bodyId) {
		String hql = "from BodyMainSymptom t1 where t1.body.id = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", Long.valueOf(bodyId));
		return find(hql, params);
	}

}
