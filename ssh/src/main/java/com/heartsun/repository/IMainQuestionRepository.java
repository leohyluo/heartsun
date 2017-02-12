package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.MainQuestion;

public interface IMainQuestionRepository {

	public List<MainQuestion> query(Long mainId, String doctorFlag, MainQuestion param) throws Exception;
}
