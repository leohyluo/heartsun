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

import com.heartsun.entity.MainQuestion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class MainQuestionControllerTest {

	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/question";
	private static final String QUERY = BASE_URL + "/query";
	
	@Resource
	private RestOperations restTemplate;
	@Test
	public void testQuery() {
		String uri = QUERY + "/2/0";
		ParameterizedTypeReference<List<MainQuestion>> typeRef = new ParameterizedTypeReference<List<MainQuestion>>() {};
		System.out.println("=============================>");
		ResponseEntity<List<MainQuestion>> response = restTemplate.exchange(uri, HttpMethod.POST, null, typeRef);
		List<MainQuestion> list = response.getBody();
		System.out.println(list.size());
		int i = 1;
		for(MainQuestion item : list) {
			System.out.println(i+":"+item.getQuestion());
			i++;
		}
	}
	
}
