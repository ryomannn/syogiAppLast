package com.example.demo.profile.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Profile implements Serializable{

	private int user_id;
	private String gender;
	private String hobby;
	private String grade;
	private String history;
	private String fav_battleType;
	private String comment;
}