package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.Folder;

public abstract class User extends Data {

	private final PersonalData personalData;
	private final Role role;
	private final Folder<?> folder;

	protected User(PersonalData personalData, Role role, Folder<?> folder) {
		this.personalData = personalData;
		this.role = role;
		this.folder = folder;
	}

	public Role getRole() {
		return role;
	}

	public Folder<?> getFolder() {
		return folder;
	}

	public UserSpec getUserSpec() {
		return new UserSpec.Builder(this).build();
	}

	public PersonalData getPersonalData() {
		return personalData;
	}
}
