package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.PersonalFolder;

public class Patient extends User {

	public Patient(PersonalData personalData, Role role,
			PersonalFolder personalFolder) {
		super(personalData, Role.PATIENT, personalFolder);
	}

}
