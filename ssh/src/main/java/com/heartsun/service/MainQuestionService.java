package com.heartsun.service;

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
	public List<MainQuestion> query(String mainId, MainQuestion param) throws Exception {
		// TODO Auto-generated method stub
		List<MainQuestion> list = questionRepository.query(mainId, param);
		for(MainQuestion item : list) {
			item.setQuestion(QEncodeUtil.decrypt(item.getQuestion()));
		}
		return list;
	}
	
	@Override
	public BaseRepository<MainQuestion> getRepository() {
		// TODO Auto-generated method stub
		return questionRepository;
	}
}
