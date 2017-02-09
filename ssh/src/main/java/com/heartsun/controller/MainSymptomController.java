package com.heartsun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.MainSymptom;
import com.heartsun.service.IMainSymptomService;

@Controller
@RequestMapping("/mainSymptom")
public class MainSymptomController {
	
	@Resource
	private IMainSymptomService mainSymptomService;

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public List<MainSymptom> query() {
		Map<String, Object> map = new HashMap<>();
		List<MainSymptom> list = mainSymptomService.query(map);
		System.out.println("list.size="+list.size());
		return list;
	}
	
	@RequestMapping(value = "/queryOne", method = RequestMethod.POST)
	@ResponseBody
	public MainSymptom queryOne() {
		Map<String, Object> map = new HashMap<>();
		List<MainSymptom> list = mainSymptomService.query(map);
		System.out.println("list.size="+list.size());
		return list.get(0);
	}
}
