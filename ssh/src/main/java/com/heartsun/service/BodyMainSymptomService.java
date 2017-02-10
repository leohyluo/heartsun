package com.heartsun.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.BodyMainSymptom;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.BodyMainSymptomRepository;

@Service
public class BodyMainSymptomService extends AbstractService<BodyMainSymptom> implements IBodyMainSymptomService {

	@Resource
	private BodyMainSymptomRepository repository;
	
	@Override
	public BaseRepository<BodyMainSymptom> getRepository() {
		return repository;
	}

	@Override
	public List<BodyMainSymptom> queryByBody(String bodyId) {
		return repository.queryByBody(bodyId);
	}
}
