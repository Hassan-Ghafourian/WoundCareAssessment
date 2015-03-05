package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.Folder;

public abstract class User {

	private final PersonalData personalData;
	private final Role role;
	private final Folder folder;

	public User(PersonalData personalData, Role role,
			Folder folder) {
		super();
		this.personalData = personalData;
		this.role = role;
		this.folder = folder;
	}

	public Role getRole() {
		return role;
	}

	public Folder getFolder() {
		return folder;
	}

	

	public PersonalData getPersonalData() {
		return personalData;
	}
}
