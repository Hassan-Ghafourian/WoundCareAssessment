package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;

public class Patient extends User {
	
	public static class Builder{
		private final PersonalData personalData;
		private final WoundFolder woundFolder;
		
		public Builder(PersonalData personalData, WoundFolder woundFolder) {
			this.personalData = personalData;
			this.woundFolder = woundFolder;
		}
		
		public Patient build(){
			return new Patient(this);
		}
	}

	private Patient(Builder builder) {
		super(builder.personalData, Role.PATIENT, builder.woundFolder);
	}

}
