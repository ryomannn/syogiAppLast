package com.example.demo.login.domain.model;

import lombok.Data;

@Data
public class User{
	private int userId;
	private String password;
	private String userAddress;
	private String userName;
	private int loginType;
	private int authority;
	private int invalidFlag;
}