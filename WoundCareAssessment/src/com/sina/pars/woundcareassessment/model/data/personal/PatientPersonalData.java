package com.sina.pars.woundcareassessment.model.data.personal;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.constants.enums.Gender;

public class PatientPersonalData extends PersonalData {
	private final Gender gender;
	private final Date dateOfBirth;
	private final String address;
	private final String telephoneNumber;
	private final String Comments;

	public PatientPersonalData(String userName, String name, String family,
			Gender gender, Date dateOfBirth, String address,
			String telephoneNumber, String comments) {
		super(userName, name, family);
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		Comments = comments;
	}

	public Gender getGender() {
		// gender.name().toLower()
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getComments() {
		return Comments;
	}

	@Override
	public String toString() {
		// gender.name().toLower()
		return super.toString() + "\t ... \t" + "PatientPersonalData [gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", telephoneNumber=" + telephoneNumber
				+ ", Comments=" + Comments + "]";
	}

}
