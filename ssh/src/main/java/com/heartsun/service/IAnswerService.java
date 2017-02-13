package com.heartsun.service;

import java.util.List;

import com.heartsun.entity.BasicAnswer;

public interface IAnswerService extends BaseService<BasicAnswer> {

	List<BasicAnswer> query(Long mainId, Integer questionNum, String isDoctor);
}
