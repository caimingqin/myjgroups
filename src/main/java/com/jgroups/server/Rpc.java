package com.jgroups.server;

public class Rpc {

	public User findUser(String code) {

		System.out.println("is called now ");
		if ("00008888".equalsIgnoreCase(code)) {
			return new User("00008888", "蔡铭琴");
		}
		return null;
	}

}
