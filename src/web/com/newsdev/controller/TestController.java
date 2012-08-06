package com.newsdev.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsdev.model.Test;
import com.newsdev.web.service.TestService;

@Controller
public class TestController extends AbstractController {
	protected Logger logger = LoggerFactory.getLogger( getClass() );
	
	@Autowired
	protected TestService testService;
	
	@RequestMapping(
			value = "/test",
			method = RequestMethod.POST
	)
	public 
	@ResponseBody
	String addTest(final Test test)
	{
		testService.add(test);
		return "success";
		
	}
	
	@RequestMapping(
			value = "/test",
			method = RequestMethod.GET
	)
	public Test getTest(
			@RequestParam( value = "id", required = false )
			String id
	)
	{
		System.out.println("getget");
		return null;
		
	}
	
}
