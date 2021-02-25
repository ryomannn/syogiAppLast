package com.example.demo.login.domain.repository;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.User;

public interface UserDao{

	//user情報を登録
	public int insertOne(User user) throws DataAccessException;

	//user情報の取得
	public Map<String, Object> selectOne(User user) throws DataAccessException;
}