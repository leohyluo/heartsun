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

import com.heartsun.entity.MainSymptom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class MainSymptomControllerTest {

	@Resource
	private RestOperations restTemplate;
	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/mainSymptom";
	private static final String MAIN_SYMPTOM_QUERY = BASE_URL + "/query";
	
	@Test
	/**
	 * 请求一个URL返回MainSymptom数组
	 */
	public void testQuery() {
		MainSymptom[] list = restTemplate.postForObject(MAIN_SYMPTOM_QUERY, null, MainSymptom[].class);
		for(MainSymptom m : list) {
			System.out.println("mobile="+m.getName());
		}
	}
	
	@Test
	/**
	 * 请求一个URL返回List<MainSymptom>
	 */
	public void testQuery1() {
		ParameterizedTypeReference<List<MainSymptom>> typeRef = new ParameterizedTypeReference<List<MainSymptom>>() {};
		ResponseEntity<List<MainSymptom>> response = restTemplate.exchange(MAIN_SYMPTOM_QUERY, HttpMethod.POST, null, typeRef);
		List<MainSymptom> list = response.getBody();
		for(MainSymptom m : list) {
			System.out.println(m.getName());
		}
	}
	
	@Test
	/**
	 * 请求一个URL返回JSON数组字符串
	 */
	public void testQuery2() {
		ResponseEntity<String> response = restTemplate.postForEntity(MAIN_SYMPTOM_QUERY, null, String.class);
		System.out.println(response.getBody());
	}
	
}
