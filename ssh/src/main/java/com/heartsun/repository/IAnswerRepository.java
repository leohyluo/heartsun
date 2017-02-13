package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.BasicAnswer;

public interface IAnswerRepository {

	List<BasicAnswer> query(Long mainId,Integer questionNum, String isDoctor);
}
