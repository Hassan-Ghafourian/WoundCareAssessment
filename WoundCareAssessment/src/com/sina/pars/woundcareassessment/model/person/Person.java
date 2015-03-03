package com.sina.pars.woundcareassessment.model.person;

import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;


public abstract class Person {
	private final PersonalData personalData;
	
	protected Person(PersonalData personalData) {
		this.personalData = personalData;
	}
	public PersonalData getPersonalData() {
		return personalData;
	}

}
