package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.BasicAnswer;
import com.heartsun.service.IAnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController extends AbstractController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private IAnswerService answerService;
	
	@RequestMapping(value = "/query/{mainId}/{questionNum}/{isDoctor}", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicAnswer> query(@PathVariable Long mainId,@PathVariable Integer questionNum, @PathVariable String isDoctor) {
		List<BasicAnswer> list = answerService.query(mainId, questionNum, isDoctor);
		logger.info("answer size = " + list.size());
		return list;
	}
}
