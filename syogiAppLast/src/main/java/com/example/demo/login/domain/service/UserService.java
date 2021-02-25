package com.example.demo.login.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService{

	@Autowired
	UserDao dao;

	public boolean insertOne(User user){

		int insertNumber = dao.insertOne(user);

		if(insertNumber > 0) {
			System.out.println("user情報insert成功");
			return true;
		}
		else {
			System.out.println("user情報insert失敗");
			return false;
		}

	}

	public User selectOne(User user) {

		User  resultUser  = new User();

		Map<String, Object> map = dao.selectOne(user);

		resultUser.setUserId((int)map.get("id"));
		resultUser.setUserAddress((String)map.get("address"));
		resultUser.setUserName((String)map.get("name"));

		return resultUser;
	}
}