package com.example.demo.login.domain.jdbc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbc;


	//user情報を登録
	@Override
	public int insertOne(User user) {

		String insertSQL = "insert into syogi.users(name, address, password) values(?,?,?)";

		int insertNumber = jdbc.update(insertSQL, user.getUserName(), user.getUserAddress(),user.getPassword());

		return insertNumber;

	}

	//user情報の取得
	@Override
	public Map<String, Object> selectOne(User user) {

		String selectSQL = "select * from syogi.users where address = ?";

		Map<String, Object> map = jdbc.queryForMap(selectSQL, user.getUserAddress());

		return map;
	}
}

