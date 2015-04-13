package com.sina.pars.woundcareassessment.model.data.person;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;

public class UserSpec extends Data {
	private final PersonalData personalData;
	private final Role role;
	
	public static class Builder{
		private final PersonalData personalData;
		private final Role role;
		
		public Builder(PersonalData personalData, Role role) {
			this.personalData = personalData;
			this.role = role;
		}
		public Builder(User user) {
			this(user.getPersonalData(), user.getRole());
		}
		
		public UserSpec build(){
			return new UserSpec(this);
		}
	}
	

	private UserSpec(Builder builder) {
		this.personalData = builder.personalData;
		this.role = builder.role;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public Role getRole() {
		return role;
	}
}
