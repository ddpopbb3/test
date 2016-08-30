package com.spring.domain;

public class User {
    private Integer userid;

    private String name;

    private String password;

    public User() {
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    @Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password=" + password + "]";
	}
}