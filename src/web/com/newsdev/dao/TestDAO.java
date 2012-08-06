package com.newsdev.dao;

import org.springframework.stereotype.Repository;

import com.newsdev.model.Test;

@Repository
public class TestDAO extends AbstractDao {
	public void addTest(final Test test)
	{
		test.setId(generateId(test));
		super.insert(test);
	}
	
}
