package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.Data;

public class Newcomer extends Data {
	private final Role role;
	private final String userName;

	public Newcomer(Role role, String userName) {
		super();
		this.role = role;
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public String getUserName() {
		return userName;
	}

}
