package com.heartsun.service;

import java.util.List;

import com.heartsun.entity.BodyMainSymptom;

public interface IBodyMainSymptomService extends BaseService<BodyMainSymptom> {

	public List<BodyMainSymptom> queryByBody(String bodyId);
}
