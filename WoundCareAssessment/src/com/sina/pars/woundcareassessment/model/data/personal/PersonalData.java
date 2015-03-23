package com.sina.pars.woundcareassessment.model.data.personal;

import com.sina.pars.woundcareassessment.model.data.Data;

public abstract class PersonalData extends Data {
	private final String userName;
	private final String name;
	private final String family;

	protected PersonalData(String userName, String name, String family) {
		this.userName = userName;
		this.name = name;
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public String getFamily() {
		return family;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "PersonalData [userName=" + userName + ", name=" + name
				+ ", family=" + family + "]";
	}

}
