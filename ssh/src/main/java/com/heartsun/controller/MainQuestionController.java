package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.MainQuestion;
import com.heartsun.service.IMainQuestionService;

@Controller
@RequestMapping("/question")
public class MainQuestionController {

	@Resource
	private IMainQuestionService questionService;
	
	@RequestMapping(value = "/query/{mainId}/{doctorFlag}", method = RequestMethod.POST)
	@ResponseBody
	public List<MainQuestion> query(@PathVariable("mainId") String mainId, @PathVariable("doctorFlag") String doctorFlag,
			MainQuestion question) throws Exception {
		List<MainQuestion> list = questionService.query(Long.valueOf(mainId), doctorFlag, question);
		System.out.println("list size = " + list.size());
		return list;
	}
}
