package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.BodyMainSymptom;

public interface IBodyMainSymptomRepository {

	public List<BodyMainSymptom> queryByBody(String bodyId);
}
