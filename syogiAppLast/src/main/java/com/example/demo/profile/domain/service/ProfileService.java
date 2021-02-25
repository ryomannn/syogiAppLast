package com.example.demo.profile.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.profile.domain.model.Profile;
import com.example.demo.profile.domain.repository.ProfileDao;

@Service
public class ProfileService{

	@Autowired
	ProfileDao dao;

	//profile情報登録
	public boolean insertOne(Profile profile) {
		int insertNumber = dao.insertOne(profile);

		if(insertNumber > 0) {
			System.out.println("Profileのinsertが成功しました");
			return true;
		}
		else {
			System.out.println("Profileのinsertが失敗しました");
			return false;
		}
	}

	//profile情報取得
	public Profile selectOne(int userId) {

		Profile profile = new Profile();

		Map<String, Object> map = dao.selectOne(userId);

		profile.setUser_id((int)map.get("user_id"));
		profile.setGender((int)map.get("gender"));
		profile.setHobby((String)map.get("hobby"));
		profile.setGrade((String)map.get("grade"));
		profile.setHistory((int)map.get("history"));
		profile.setComment((String)map.get("comment"));

		return profile;
	}

	//profileのアップデート
	public boolean updateOne(Profile profile){
		int updateNumber = dao.updataOne(profile);

		if(updateNumber > 0) {
			System.out.println("Profileのupdateが成功しました");
			return true;
		}
		else {
			System.out.println("Profileのupdateが失敗しました");
			return false;
		}
	}


}