package com.heartsun.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.entity.QuestionAndAnswer;
import com.heartsun.entity.resultset.AnswerPojo;
import com.heartsun.utils.QEncodeUtil;

@Repository
@SuppressWarnings("unchecked")
public class AnswerRepository extends BaseRepository<BasicAnswer> implements IAnswerRepository {

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

	
	@Override
	public List<AnswerPojo> queryList(Long mainId, Integer questionNum, String isDoctor) {
		StringBuilder sb = new StringBuilder("SELECT tab1.num,tab1.answerRelationIds,tab1.diseaseIds,tab1.answerText");
		sb.append(" FROM (")
		.append("SELECT ")
		.append("count(*) num,")
		.append("GROUP_CONCAT(t1.CM001) answerRelationIds,")
		.append("GROUP_CONCAT(t1.CM002) diseaseIds,")
		.append("t2.CM003 answerText FROM tm004 t1")
		.append(" LEFT JOIN tm003 t2 ON t1.CM004 = t2.CM002")
		.append(" WHERE ")
		.append(" t1.CM006 = ?");	//主症状id
		sb.append(" AND t1.CM005 = ?");	//第几个问题
		sb.append(" AND t1.CM007 = ?");	//导诊版本
		sb.append(" GROUP BY t1.CM004");
		sb.append(") tab1 ORDER BY tab1.num DESC");
		String sql = sb.toString();
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setLong(0, mainId);
		query.setInteger(1, questionNum);
		query.setString(2, isDoctor);
		List<Object[]> list = query.list();
		List<AnswerPojo> answerList = new ArrayList<>();
		for(Object[] arr : list) {
			AnswerPojo pojo = new AnswerPojo();
			pojo.setDiseaseNum(Integer.parseInt(arr[0].toString()));
			pojo.setAnswerIds(arr[1].toString());
			pojo.setDiseaseIds(arr[2].toString());
			try {
				pojo.setAnswerText(QEncodeUtil.decrypt(arr[3].toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			pojo.setNormalDiseaseCount(-1);
			answerList.add(pojo);
		}
		return answerList;
	}

}
