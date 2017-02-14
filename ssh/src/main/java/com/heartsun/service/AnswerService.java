package com.heartsun.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.entity.QuestionAndAnswer;
import com.heartsun.entity.resultset.AnswerPojo;
import com.heartsun.repository.AnswerRepository;
import com.heartsun.repository.BaseRepository;

@Service
public class AnswerService extends AbstractService<BasicAnswer> implements IAnswerService {

	@Resource
	private AnswerRepository answerRepository;
	@Resource
	private IDiseaseService diseaseService;
	
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
	public List<AnswerPojo> queryDistinctList(Long mainId, Integer questionNum, String isDoctor) {
		List<AnswerPojo> originList = answerRepository.queryList(mainId, questionNum, isDoctor);
		//对疾病个数相同的答案进行常见病查询，疾病个数相同的情况下常见疾病较多的排前面
		Map<Integer, List<AnswerPojo>> map = new HashMap<>();	//key为疾病个数,value为相同疾病个数的答案数量容器
		for(AnswerPojo pojo : originList) {
			Integer diseaseNum = pojo.getDiseaseNum();
			if(!map.containsKey(diseaseNum)) {
				List<AnswerPojo> itemList = new ArrayList<>();
				itemList.add(pojo);
				map.put(diseaseNum, itemList);
			} else {
				map.get(diseaseNum).add(pojo);
			}
		}
		//如答案的疾病个数相同,则找此答案对应的常见疾病数量
		for(Integer diseaseNum : map.keySet()) {
			List<AnswerPojo> itemList = map.get(diseaseNum);
			if(itemList.size() == 1) {
				continue;
			}
			for(AnswerPojo pojo : itemList) {
				String diseaseIds = pojo.getDiseaseIds();
				List<String> diseaseIdList = Arrays.asList(diseaseIds.split(","));
				List<Long> idList = new ArrayList<>();
				for(String id : diseaseIdList) {
					idList.add(Long.valueOf(id));
				}
				//查询答案对应常见疾病个数
				Integer normalDiseaseCount = diseaseService.queryNormalCount(idList);
				pojo.setNormalDiseaseCount(normalDiseaseCount);		
			}
		}
		List<AnswerPojo> targetList = new ArrayList<>();
		for(Integer diseaseNum : map.keySet()) {
			targetList.addAll(map.get(diseaseNum));
		}
		//疾病个数多的答案排前面,如疾病个数相同则常见疾病个数多的排前面
		Collections.sort(targetList);
		return targetList;
	}

	@Override
	public BaseRepository<BasicAnswer> getRepository() {
		// TODO Auto-generated method stub
		return answerRepository;
	}
}
