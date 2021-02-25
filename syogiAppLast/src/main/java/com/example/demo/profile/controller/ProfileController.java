package com.example.demo.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.profile.domain.model.Profile;
import com.example.demo.profile.domain.service.ProfileService;


@Controller
public class ProfileController{

	@Autowired
	ProfileService profileService;

	//プロフィール画面の表示
	@GetMapping("/profile")
	public String getProfile(Model model) {

		Profile result = new Profile();

		//userIDをsesseionで管理して取ってくる
		int userId =1;

		//profile情報取得
		result = profileService.selectOne(userId);

		model.addAttribute("result", result);

		return "/profile";
	}

	//プロフィール入力画面の表示
	@GetMapping("/profileInput")
	public String getProfileInput(Model model) {

		return "/profileInput";
	}

	//入力されたプロフィール情報をDBに登録
	@PostMapping("/profileInput")
	public String postProfileInput(@ModelAttribute Profile profile, Model model) {

		System.out.println("profile情報: " + profile);

		profileService.updateOne(profile);

		return getProfile(model);

	}
}