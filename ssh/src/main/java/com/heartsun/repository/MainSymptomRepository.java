package com.heartsun.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heartsun.entity.MainSymptom;

@Repository
public class MainSymptomRepository extends BaseRepository<MainSymptom> implements IMainSymptomRepository {

	public List<MainSymptom> query(Map<String, Object> map) {
		String hql = "from MainSymptom";
		return find(hql, map);
	}
}
