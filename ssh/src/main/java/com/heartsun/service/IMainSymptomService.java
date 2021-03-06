package com.heartsun.service;

import java.util.List;
import java.util.Map;

import com.heartsun.entity.MainSymptom;

public interface IMainSymptomService extends BaseService<MainSymptom> {
	
	List<MainSymptom> query(Map<String, Object> map);

}
