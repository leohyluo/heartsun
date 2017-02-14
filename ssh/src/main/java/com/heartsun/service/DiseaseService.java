package com.heartsun.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.Disease;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.DiseaseRepository;

@Service
public class DiseaseService extends AbstractService<Disease> implements IDiseaseService {

	@Resource
	private DiseaseRepository repository;
	
	@Override
	public List<Disease> queryNormals(List<String> diseaseIds) {
		return repository.queryNormals(diseaseIds);
	}

	@Override
	public Integer queryNormalCount(List<Long> diseaseIds) {
		return repository.queryNormalCount(diseaseIds);
	}
	
	@Override
	public BaseRepository<Disease> getRepository() {
		return repository;
	}
}
