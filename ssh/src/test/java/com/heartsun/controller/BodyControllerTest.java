package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.heartsun.entity.Body;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class BodyControllerTest {
	
	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/body";
	private static final String BODY_QUERY = BASE_URL + "/query";
	
	@Resource
	private RestOperations restTemplate;
	
	@Test
	public void testQuery() {
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(param, headers);
		
		ParameterizedTypeReference<List<Body>> typeRef = new ParameterizedTypeReference<List<Body>>() {};
		ResponseEntity<List<Body>> response = restTemplate.exchange(BODY_QUERY, HttpMethod.POST, httpEntity, typeRef);
		List<Body> bodyList = response.getBody();
		System.out.println("body size = " + bodyList.size());
		
		for(Body body : bodyList) {
			System.out.println(body.getName());
		}
	}
}
