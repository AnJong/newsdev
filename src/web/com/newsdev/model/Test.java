package com.newsdev.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	@Id
	protected String id;
	
	protected String title;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "Test[" + getId() + "]";
	}
}
