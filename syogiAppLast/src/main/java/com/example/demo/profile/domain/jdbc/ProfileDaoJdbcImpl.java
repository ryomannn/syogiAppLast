package com.example.demo.profile.domain.jdbc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.profile.domain.model.Profile;
import com.example.demo.profile.domain.repository.ProfileDao;

@Repository
public class ProfileDaoJdbcImpl implements ProfileDao {

	@Autowired
	JdbcTemplate jdbc;

	//profile情報登録
	@Override
	public int insertOne(Profile profile) {

		String updateSQL = "insert into syogi.profile(user_id, gender, hobby, history, grade, fav_battleType, comment) values(?,?,?,?,?,?,?)";

		int insertNumber = jdbc.update(updateSQL, profile.getUser_id(), profile.getGender(), profile.getHobby(), profile.getHistory(), profile.getFav_battleType(),profile.getComment());

		return insertNumber;
	}

	//profile情報取得
	@Override
	public Map<String, Object> selectOne(int userId) {

		String selectSQL = "select * from syogi.profile where user_id=?";

		Map<String, Object> map = jdbc.queryForMap(selectSQL, userId);

		return map;
	}

	//profileのアップデート
	@Override
	public int updataOne(Profile profile) {

		String updateSQL = "update syogi.profile set gender=?, hobby=?, history=?, grade=?, fav_battleType=?, comment=? where user_id = ?";


		int updateNumber = jdbc.update(updateSQL, profile.getGender(), profile.getHobby(), profile.getHistory(),profile.getGrade(), profile.getFav_battleType(), profile.getUser_id());

		return updateNumber;
	}

}