package com.heartsun.repository;

import java.util.List;

import com.heartsun.entity.QuestionAndAnswer;
import com.heartsun.entity.resultset.AnswerPojo;

public interface IAnswerRepository {

	List<QuestionAndAnswer> query(Long mainId,Integer questionNum, String isDoctor);
	
	/**
	 * 根据主症状id、问题步数、版本查询答案
	 * @param mainId
	 * @param questionNum
	 * @param isDoctor
	 * @return 答案对应疾病个数最多的放在前面
	 */
	List<AnswerPojo> queryList(Long mainId,Integer questionNum, String isDoctor);
}
