package com.sina.pars.woundcareassessment.model.generators.data;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Gender;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class PatientPersonalDataGenerator implements
		Generator<String, PatientPersonalData> {

	private final static PatientPersonalDataGenerator instance = new PatientPersonalDataGenerator();

	@Override
	public PatientPersonalData generate(String userName) {
		String name = userName + "_Name";
		String family = userName + "_Family";
		Gender gender = Gender.MALE;
		Date dateOfBirth = new Date();
		String address = userName + "_Address";
		String telephoneNumber = userName + "_Tel";
		String comments = userName + "_Comments";
		return new PatientPersonalData.Builder(gender, dateOfBirth, address,
				telephoneNumber, comments, userName, name, family).build();
	}

	private PatientPersonalDataGenerator() {
	}

	public static PatientPersonalDataGenerator getInstance() {
		return instance;
	}

}
