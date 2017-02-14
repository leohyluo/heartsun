package com.heartsun.service;

import java.util.List;

import com.heartsun.entity.Disease;

public interface IDiseaseService {

	public List<Disease> queryNormals(List<String> diseaseIds);
	
	public Integer queryNormalCount(List<Long> diseaseIds);
}
