package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;
import com.example.demo.profile.domain.model.Profile;
import com.example.demo.profile.domain.service.ProfileService;

@Controller
public class UserController{

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;

	//login画面の表示
	@GetMapping("/login")
	public String getLogin(Model model) {

		return "/login";
	}

	//login入力画面の表示
	@GetMapping("/loginInput")
	public String getLoginInput(@ModelAttribute User user, @ModelAttribute Profile profile, Model model) {

		return "/loginInput";
	}


	//user情報とProfile情報を登録
	@PostMapping("/loginInput")
	public String postLoginInput(@ModelAttribute User user, @ModelAttribute Profile profile, Model model) {

		//user情報登録
		userService.insertOne(user);

		//profile情報登録
		profileService.insertOne(profile);

		return "redirect:/login";

	}
}