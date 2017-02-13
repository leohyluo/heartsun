package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

import com.heartsun.entity.QuestionAndAnswer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class AnswerControllerTest {

	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/answer";
	private static final String ANSWER_QUERY = BASE_URL + "/query";
	
	@Resource
	private RestOperations restTemplate;
	
	@Test
	public void testQuery() {
		String uri = ANSWER_QUERY + "/2/1/1";
		ParameterizedTypeReference<List<QuestionAndAnswer>> typeReference = new ParameterizedTypeReference<List<QuestionAndAnswer>>() {};
		ResponseEntity<List<QuestionAndAnswer>> response = restTemplate.exchange(uri, HttpMethod.POST, null, typeReference);
		List<QuestionAndAnswer> list = response.getBody();
		int i = 1;
		for(QuestionAndAnswer item : list) {
			System.out.println("====>" +i +":"+item.getId() +":"+ item.getBasicAnswer().getDecodeAnswerContent());
			i++;
		}
	}
	
	@Test
	public void testQuery2() {
		String uri = ANSWER_QUERY + "/2/1/1";
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, null, String.class);
		String content = response.getBody();
		System.out.println(content);
	}
}
