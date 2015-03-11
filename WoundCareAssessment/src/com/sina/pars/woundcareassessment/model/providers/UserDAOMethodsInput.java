package com.sina.pars.woundcareassessment.model.providers;

import com.sina.pars.woundcareassessment.model.constants.enums.userdao.EffectDestinationType;
import com.sina.pars.woundcareassessment.model.data.person.User;

public class UserDAOMethodsInput {
	private final EffectDestinationType effectDestinationType;
	private String userName = "";
	private User user;

	public UserDAOMethodsInput(EffectDestinationType effectDestinationType) {
		this.effectDestinationType = effectDestinationType;
	}

	public UserDAOMethodsInput setUser(User user) {
		this.user = user;
		return this;
	}

	public UserDAOMethodsInput setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public EffectDestinationType getEffectDestinationType() {
		return effectDestinationType;
	}

	public String getUserName() {
		return userName;
	}

	public User getUser() {
		return user;
	}

}
