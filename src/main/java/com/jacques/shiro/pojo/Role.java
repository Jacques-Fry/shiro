package com.jacques.shiro.pojo;

import java.io.Serializable;

public class Role implements Serializable{
	
	private static final long serialVersionUID = -227437593919820521L;
	private Integer id;
	private String name;
	private String nickname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
