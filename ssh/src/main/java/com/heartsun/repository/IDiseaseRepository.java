package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.Disease;

public interface IDiseaseRepository {

	List<Disease> queryNormals(List<String> diseaseIds);
	
	/**
	 * 根据疾病id集合中有多少个常见疾病
	 * @param diseaseIds
	 * @return
	 */
	Integer queryNormalCount(List<Long> diseaseIds);
}
