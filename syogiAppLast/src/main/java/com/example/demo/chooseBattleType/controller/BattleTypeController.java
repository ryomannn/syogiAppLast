package com.example.demo.chooseBattleType.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.chooseBattleType.domain.model.BattleType;
import com.example.demo.chooseBattleType.domain.service.BattleTypeService;

@Controller
public class BattleTypeController{

	@Autowired
	BattleTypeService battleTypeService;

	@GetMapping("/battleType")
	public String getBattleType(@ModelAttribute BattleType battleType, Model model) {

		List<BattleType> battleTypeList = battleTypeService.selectAll();

		model.addAttribute("battleTypeLists", battleTypeList);

		return "/battleType";

	}

	@PostMapping("/battleType")
	public String postBattleType(@ModelAttribute BattleType battleType, Model model) {

		System.out.println(battleType);

		return "/room";

	}
}