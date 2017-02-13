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
	/**
	 * 查询主症状id为2,患者版的问题
	 */
	@Test
	public void testQuery() {
		String uri = QUERY + "/2/0";
		ParameterizedTypeReference<List<MainQuestion>> typeRef = new ParameterizedTypeReference<List<MainQuestion>>() {};
		ResponseEntity<List<MainQuestion>> response = restTemplate.exchange(uri, HttpMethod.POST, null, typeRef);
		List<MainQuestion> list = response.getBody();
		int i = 1;
		for(MainQuestion item : list) {
			System.out.println(i+":"+item.getDecodeQuestion());
			i++;
		}
	}
	/**
	 * 查询主症状id为2,医生版的问题
	 */
	@Test
	public void testQuery2() {
		String uri = QUERY + "/2/1";
		ParameterizedTypeReference<List<MainQuestion>> typeRef = new ParameterizedTypeReference<List<MainQuestion>>() {};
		ResponseEntity<List<MainQuestion>> response = restTemplate.exchange(uri, HttpMethod.POST, null, typeRef);
		List<MainQuestion> list = response.getBody();
		int i = 1;
		for(MainQuestion item : list) {
			System.out.println(i+":"+item.getDecodeQuestion());
			i++;
		}
	}
	
}
