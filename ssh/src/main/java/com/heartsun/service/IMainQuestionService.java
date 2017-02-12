package com.heartsun.service;

import java.util.List;

import com.heartsun.entity.MainQuestion;

public interface IMainQuestionService extends BaseService<MainQuestion> {
	
	public List<MainQuestion> query(Long mainId, String doctorFlag, MainQuestion param) throws Exception;

}
