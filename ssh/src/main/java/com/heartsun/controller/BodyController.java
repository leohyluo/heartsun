package com.heartsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.Body;
import com.heartsun.service.IBodyService;

@Controller
@RequestMapping("/body")
public class BodyController extends AbstractController {
	
	@Resource
	private IBodyService bodyService;

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public List<Body> query(Body body) throws Exception {
		return bodyService.get(body);
	}
}
