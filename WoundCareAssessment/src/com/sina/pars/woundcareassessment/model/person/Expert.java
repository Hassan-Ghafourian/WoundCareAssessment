package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.PersonalFolder;

public class Expert extends User {

	protected Expert(PersonalData personalData, PersonalFolder personalFolder,
			String userName) {
		super(personalData, Role.Expert, personalFolder, userName);
	}

}
