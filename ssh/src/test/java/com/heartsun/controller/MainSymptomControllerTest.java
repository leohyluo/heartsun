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

import com.heartsun.entity.MainSymptom;
import com.heartsun.utils.HttpUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-client.xml"})
public class MainSymptomControllerTest {

	@Resource
	private RestOperations restTemplate;
	private static final String BASE_URL = "http://127.0.0.1:8080/ssh/mainSymptom";
	private static final String MAIN_SYMPTOM_QUERY = BASE_URL + "/query";
	
	@Test
	/**
	 * 请求URL返回MainSymptom数组
	 */
	public void testQuery() {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("sex", "1");
		MainSymptom[] list = restTemplate.postForObject(MAIN_SYMPTOM_QUERY, param, MainSymptom[].class);
		for(MainSymptom m : list) {
			System.out.println("mobile="+m.getName());
		}
	}
	
	@Test
	/**
	 * 请求URL返回List<MainSymptom>
	 */
	public void testQuery1() {
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("sex", "1");
		//param.add("sex", 1);此写法无法注入controller
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param, headers);
		
		ParameterizedTypeReference<List<MainSymptom>> typeRef = new ParameterizedTypeReference<List<MainSymptom>>() {};
		ResponseEntity<List<MainSymptom>> response = restTemplate.exchange(MAIN_SYMPTOM_QUERY, HttpMethod.POST, httpEntity, typeRef);
		List<MainSymptom> list = response.getBody();
		for(MainSymptom m : list) {
			System.out.println(m.getName());
		}
	}
	
	@Test
	/**
	 * 请求URL返回JSON数组的字符串
	 */
	public void testQuery2() {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("sex", "1");
		ResponseEntity<String> response = restTemplate.postForEntity(MAIN_SYMPTOM_QUERY, param, String.class);
		System.out.println(response.getBody());
	}
	
	@Test
	public void testQuery3() {
		MainSymptom[] list = restTemplate.postForObject(MAIN_SYMPTOM_QUERY+"?sex=1", null, MainSymptom[].class);
		for(MainSymptom m : list) {
			System.out.println("mobile="+m.getName());
		}
	}
	
	@Test
	public void testQuery4() {
		long val = 37;
		String param = "id="+val;
		HttpUtils.doPost(MAIN_SYMPTOM_QUERY, param);
	}
}
