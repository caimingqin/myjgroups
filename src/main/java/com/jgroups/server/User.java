package com.jgroups.server;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -44634887650200037L;

	private String code;
	private String name;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
}
