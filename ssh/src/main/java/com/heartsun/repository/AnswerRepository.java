package com.heartsun.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.entity.QuestionAndAnswer;

@Repository
public class AnswerRepository extends BaseRepository<BasicAnswer> implements IAnswerRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionAndAnswer> query(Long mainId, Integer questionNum, String isDoctor) {
		StringBuffer sb = new StringBuffer();
		sb.append("from QuestionAndAnswer t1 where t1.mainSymptom.id = ? and t1.questionNum = ?");
		sb.append(" and t1.isdoctor = ? order by t1.order_,t1.id");
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong(0, mainId);
		query.setInteger(1, questionNum);
		query.setString(2, isDoctor);
		return query.list();
	}

}
