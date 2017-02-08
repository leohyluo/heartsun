package com.heartsun.repository;

import java.util.List;
import java.util.Map;

import com.heartsun.entity.MainSymptom;

public interface IMainSymptomRepository {

	List<MainSymptom> query(Map<String, Object> map);
}
