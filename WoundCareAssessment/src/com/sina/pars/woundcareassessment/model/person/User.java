package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.Folder;

public class User extends Person {

	private final String userName;
	private final Role role;
	private final Folder folder;

	protected User(PersonalData personalData, Role role, Folder folder, String userName) {
		super(personalData);
		this.role = role;
		this.folder = folder;
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public Folder getFolder() {
		return folder;
	}

	public String getUserName() {
		return userName;
	}

}
