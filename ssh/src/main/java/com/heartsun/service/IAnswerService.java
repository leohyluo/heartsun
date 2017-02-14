package com.heartsun.service;

import java.util.List;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.entity.QuestionAndAnswer;
import com.heartsun.entity.resultset.AnswerPojo;

public interface IAnswerService extends BaseService<BasicAnswer> {

	List<QuestionAndAnswer> query(Long mainId, Integer questionNum, String isDoctor);
	
	List<AnswerPojo> queryDistinctList(Long mainId, Integer questionNum, String isDoctor);
}
