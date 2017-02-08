package com.heartsun.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class UserControllerTest {

	@Resource
	private RestOperations restTemplate;
	
	@Test
	public void test1() {
		String url = "http://127.0.0.1:8080/ssh/getById";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(url, null, String.class);
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		try {
			String url = "http://127.0.0.1:8080/ssh/getById";
			String result = restTemplate.postForObject(url, null, String.class);
			System.out.println("==============>"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
