package com.heartsun.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	
	@Test
	public void testQuery() {
		String uri = BASE_URL + "/query";
		ResponseEntity<MainSymptom> response = restTemplate.postForEntity(uri, null, MainSymptom.class);
		response.getBody();
		System.out.println("end");
	}
}
