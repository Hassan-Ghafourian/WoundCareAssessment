package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.PersonalFolder;

public class Patient extends User {

	protected Patient(PersonalData personalData, PersonalFolder personalFolder,
			String userName) {
		super(personalData, Role.Patient, personalFolder, userName);
	}

}
