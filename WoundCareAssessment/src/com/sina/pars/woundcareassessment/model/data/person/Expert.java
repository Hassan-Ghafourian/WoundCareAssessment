package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.Folder;

public class Expert extends User {
	
	public static class Builder{
		private final PersonalData personalData;
		private final Folder<?> folder;
		
		public Builder(PersonalData personalData, Folder<?> folder) {
			this.personalData = personalData;
			this.folder = folder;
		}
		
		public Expert build(){
			return new Expert(this);
		}
	}

	private Expert(Builder builder) {
		super(builder.personalData, Role.EXPERT, builder.folder);
	}

	
}
