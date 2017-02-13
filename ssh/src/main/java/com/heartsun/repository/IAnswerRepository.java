package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.QuestionAndAnswer;

public interface IAnswerRepository {

	List<QuestionAndAnswer> query(Long mainId,Integer questionNum, String isDoctor);
}
