package com.newsdev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsdev.dao.TestDAO;
import com.newsdev.model.Test;
import com.newsdev.web.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	protected final Logger logger = LoggerFactory.getLogger( getClass() );
	
	@Autowired
	protected TestDAO testDao;
	
	@Override
	public Test add(Test test) {
		
		testDao.addTest(test);
		return null;
	}
	
}
