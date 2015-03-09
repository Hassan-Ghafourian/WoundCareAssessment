package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;

public class UserSpec {
	private final PersonalData personalData;
	private final Role role;

	protected UserSpec(PersonalData personalData, Role role) {
		this.personalData = personalData;
		this.role = role;
	}

	protected UserSpec(User user) {
		this.personalData = user.getPersonalData();
		this.role = user.getRole();
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public Role getRole() {
		return role;
	}
}
