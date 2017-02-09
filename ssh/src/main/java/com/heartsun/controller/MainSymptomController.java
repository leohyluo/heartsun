package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.MainSymptom;
import com.heartsun.service.IMainSymptomService;

@Controller
@RequestMapping("/mainSymptom")
public class MainSymptomController extends AbstractController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private IMainSymptomService mainSymptomService;

	/*@RequestMapping(value = "/queryTest", method = RequestMethod.POST)
	@ResponseBody
	public List<MainSymptom> query(@RequestParam Map<String, Object> map) {
		List<MainSymptom> list = mainSymptomService.query(map);
		System.out.println("list.size="+list.size());
		return list;
	}*/
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public List<MainSymptom> query(MainSymptom m) throws Exception {
		List<MainSymptom> list = null;
		list = mainSymptomService.get(m);
		logger.info("MainSymptom size = " + list.size());
		return list;
	}
	
}
