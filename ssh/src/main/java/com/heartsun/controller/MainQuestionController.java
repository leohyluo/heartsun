package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heartsun.entity.MainQuestion;
import com.heartsun.service.IMainQuestionService;

@Controller
@RequestMapping("/question")
public class MainQuestionController {

	@Resource
	private IMainQuestionService questionService;
	
	@RequestMapping(value = "/query/{mainId}", method = RequestMethod.POST)
	public List<MainQuestion> query(@PathVariable String mainId, MainQuestion question) throws Exception {
		List<MainQuestion> list = questionService.query(mainId, question);
		return list;
	}
}
