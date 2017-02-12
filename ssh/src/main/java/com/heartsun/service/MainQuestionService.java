package com.heartsun.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.MainQuestion;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.MainQuestionRepository;
import com.heartsun.utils.QEncodeUtil;

@Service
public class MainQuestionService extends AbstractService<MainQuestion> implements IMainQuestionService {
	
	@Resource
	private MainQuestionRepository questionRepository;

	@Override
	public List<MainQuestion> query(Long mainId, String doctorFlag, MainQuestion param) throws Exception {
		// TODO Auto-generated method stub
		List<MainQuestion> list = questionRepository.query(mainId, doctorFlag, param);
		List<MainQuestion> targetList = new ArrayList<>();
		for(MainQuestion item : list) {
			MainQuestion target = item;
			target.setQuestion(QEncodeUtil.decrypt(target.getQuestion()));
			targetList.add(target);
		}
		return targetList;
	}
	
	@Override
	public BaseRepository<MainQuestion> getRepository() {
		// TODO Auto-generated method stub
		return questionRepository;
	}
}
