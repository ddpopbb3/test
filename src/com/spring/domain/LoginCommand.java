package com.spring.domain;

public class LoginCommand {
	private String name;

	private String password;

	public LoginCommand() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginCommand [name=" + name + ", password=" + password + "]";
	}
}
