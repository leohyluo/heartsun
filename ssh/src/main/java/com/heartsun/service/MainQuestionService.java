package com.heartsun.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.MainQuestion;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.MainQuestionRepository;

@Service
public class MainQuestionService extends AbstractService<MainQuestion> implements IMainQuestionService {
	
	@Resource
	private MainQuestionRepository questionRepository;

	@Override
	public List<MainQuestion> query(Long mainId, String doctorFlag, MainQuestion param) throws Exception {
		// TODO Auto-generated method stub
		List<MainQuestion> list = questionRepository.query(mainId, doctorFlag, param);
		return list;
	}
	
	@Override
	public BaseRepository<MainQuestion> getRepository() {
		// TODO Auto-generated method stub
		return questionRepository;
	}
}
