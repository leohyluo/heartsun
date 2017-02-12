package com.heartsun.repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.heartsun.entity.MainQuestion;

@Repository
@SuppressWarnings("all")
public class MainQuestionRepository extends BaseRepository<MainQuestion> implements IMainQuestionRepository {

	@Override
	public List<MainQuestion> query(Long mainId, String doctorFlag, MainQuestion question) throws Exception {
		String hql = "from MainQuestion where mainSymptom.id = ? and isdoctor = ?";
		List<Object> baseArgs = new ArrayList<>();
		baseArgs.add(mainId);
		baseArgs.add(doctorFlag);
		return find(hql, "questionType", question, baseArgs);
	}

	
}
