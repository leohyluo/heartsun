package com.heartsun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.heartsun.framework.web.BasicTypeEditor;


@ControllerAdvice
public class AbstractController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
//		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(int.class, new BasicTypeEditor(int.class));
		binder.registerCustomEditor(long.class, new BasicTypeEditor(long.class));
		binder.registerCustomEditor(double.class, new BasicTypeEditor(double.class));
		binder.registerCustomEditor(float.class, new BasicTypeEditor(float.class));
		binder.registerCustomEditor(char.class, new BasicTypeEditor(char.class));
		binder.registerCustomEditor(boolean.class, new BasicTypeEditor(boolean.class));
		binder.registerCustomEditor(short.class, new BasicTypeEditor(short.class));
		binder.registerCustomEditor(byte.class, new BasicTypeEditor(byte.class));
	}
	
	@ExceptionHandler
	public void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("error happened======================");
		logger.warn(ex.getMessage());
		logger.error("error happen ", ex);
		ex.printStackTrace();
	}
}
