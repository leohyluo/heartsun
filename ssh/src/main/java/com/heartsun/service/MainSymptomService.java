package com.heartsun.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.MainSymptom;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.MainSymptomRepository;

@Service
public class MainSymptomService extends AbstractService<MainSymptom> implements IMainSymptomService {
	
	@Resource
	private MainSymptomRepository mainSymptomRepository;

	public List<MainSymptom> query(Map<String, Object> map) {
		return mainSymptomRepository.query(map);
	}
	
	@Override
	public BaseRepository<MainSymptom> getRepository() {
		return mainSymptomRepository;
	}
}
