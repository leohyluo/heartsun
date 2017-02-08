package com.heartsun.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.Worker;
import com.heartsun.service.IWorkerService;

@Controller
public class UserController {
	
	@Resource
	private IWorkerService workerService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public String getById() {
		Long id = 1L;
		Worker worker = workerService.findById(id);
		System.out.println(worker.getMobile());
		return worker.getMobile();
	}
}
