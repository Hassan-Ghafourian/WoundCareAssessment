package com.sina.pars.woundcareassessment.model.data.personal;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Gender;

public class PatientPersonalData extends PersonalData {
	private final Gender gender;
	private final Date dateOfBirth;
	private final String address;
	private final String telephoneNumber;
	private final String comments;

	public static class Builder {
		private final Gender gender;
		private final Date dateOfBirth;
		private final String address;
		private final String telephoneNumber;
		private final String comments;
		private final String userName;
		private final String name;
		private final String family;

		public Builder(Gender gender, Date dateOfBirth, String address,
				String telephoneNumber, String comments, String userName,
				String name, String family) {
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.telephoneNumber = telephoneNumber;
			this.comments = comments;
			this.userName = userName;
			this.name = name;
			this.family = family;
		}

		public PatientPersonalData build() {
			return new PatientPersonalData(this);
		}
	}

	private PatientPersonalData(Builder builder) {
		super(builder.userName, builder.name, builder.family);
		this.gender = builder.gender;
		this.dateOfBirth = builder.dateOfBirth;
		this.address = builder.address;
		this.telephoneNumber = builder.telephoneNumber;
		comments = builder.comments;
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
		return comments;
	}

	@Override
	public String toString() {
		// gender.name().toLower()
		return super.toString() + "\t ... \t" + "PatientPersonalData [gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", telephoneNumber=" + telephoneNumber
				+ ", comments=" + comments + "]";
	}

}
