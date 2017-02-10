package com.heartsun.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class BodyMainSymptomControllerTest {
	
	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/bodyMainSymptom";
	private static final String QUERY_ALL = BASE_URL + "/queryAll";
	private static final String QUERY_BY_BODY = BASE_URL + "/queryByBody";
	
	@Resource
	private RestOperations restTemplate;
	
	@Test
	public void testQuery() {
		ResponseEntity<String> response = restTemplate.exchange(QUERY_ALL, HttpMethod.POST, null, String.class);
		String body = response.getBody();
		System.out.println(body);
	}
	
	@Test
	public void testQueryByBody() {
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("bodyId", "3");
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(param, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(QUERY_BY_BODY, HttpMethod.POST, httpEntity, String.class);
		String body = response.getBody();
		System.out.println(body);
	}
}
