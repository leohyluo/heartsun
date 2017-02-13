package com.heartsun.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.entity.QuestionAndAnswer;
import com.heartsun.repository.AnswerRepository;
import com.heartsun.repository.BaseRepository;

@Service
public class AnswerService extends AbstractService<BasicAnswer> implements IAnswerService {

	@Resource
	private AnswerRepository answerRepository;
	
	@Override
	public List<QuestionAndAnswer> query(Long mainId, Integer questionNum, String isDoctor) {
		// TODO Auto-generated method stub
		List<QuestionAndAnswer> list = answerRepository.query(mainId, questionNum, isDoctor);
		for(QuestionAndAnswer item : list) {
			item.getBasicAnswer().setDecodeAnswerContent();
		}
		return list;
	}

	@Override
	public BaseRepository<BasicAnswer> getRepository() {
		// TODO Auto-generated method stub
		return answerRepository;
	}

	

}
