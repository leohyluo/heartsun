package com.heartsun.controller;

import java.util.List;

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
		try {
			String uri = BASE_URL + "/query";
			//ResponseEntity<MainSymptom> response = restTemplate.postForEntity(uri, null, MainSymptom.class);
			ResponseEntity<List> response = restTemplate.postForEntity(uri, null, List.class);
			List list = response.getBody();
			System.out.println("size=="+list.size());
			for(int i = 0; i<list.size(); i++) {
				MainSymptom m = (MainSymptom) list.get(i);
				System.out.println("mobile="+m.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery2() {
		try {
			String uri = BASE_URL + "/query";
			ResponseEntity<String> response = restTemplate.postForEntity(uri, null, String.class);
			System.out.println(response.getBody());
			System.out.println("end");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
