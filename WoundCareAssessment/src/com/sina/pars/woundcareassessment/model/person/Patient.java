package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.PersonalFolder;

public class Patient extends User {

	public Patient(String userName, PersonalData personalData, Role role,
			PersonalFolder personalFolder) {
		super(personalData, Role.Patient, personalFolder);
	}

}
