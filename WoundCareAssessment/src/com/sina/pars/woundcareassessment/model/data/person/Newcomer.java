package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;

public class Newcomer {
	private final Role role;
	private final String userName;

	public Newcomer(Role role, String userName) {
		super();
		this.role = role;
		this.userName = userName;
	}

}
