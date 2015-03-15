package com.sina.pars.woundcareassessment.model.providers;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.userdao.EffectDestinationType;
import com.sina.pars.woundcareassessment.model.data.person.User;

public class UserDAOMethodsInput {
	private final EffectDestinationType effectDestinationType;
	private String userName;
	private final User user;
	private final ID id;

	public UserDAOMethodsInput(ID id,
			EffectDestinationType effectDestinationType, String userName, User user) {
		this.effectDestinationType = effectDestinationType;
		this.userName = userName;
		this.id = id;
		this.user = user;
		if (user != null) {
			this.userName = user.getPersonalData().getUserName();
		}
		if (userName == null) {
			throw new IllegalArgumentException(
					"Atleast one of the user or userName in input arguments must not be null");
		}
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

	public ID getId() {
		return id;
	}

}
