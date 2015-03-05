
package com.sina.pars.woundcareassessment.model.data.personal;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.constants.enums.Gender;
import com.sina.pars.woundcareassessment.model.constants.enums.WoundSite;

public class PatientPersonalData extends PersonalData {
	private final Gender gender;
	private final Date dateOfBirth;
	private final String address;
	private final WoundSite woundSite;
	private final String telephoneNumber;
	private final String yearofDiagnosis;
	private final String Comments;

	public PatientPersonalData(String userName, String name, String family,
			Gender gender, Date dateOfBirth, String address,
			WoundSite woundSite, String telephoneNumber,
			String yearofDiagnosis, String comments) {
		super(userName, name, family);
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.woundSite = woundSite;
		this.telephoneNumber = telephoneNumber;
		this.yearofDiagnosis = yearofDiagnosis;
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

	public WoundSite getWoundSite() {
		return woundSite;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getYearofDiagnosis() {
		return yearofDiagnosis;
	}

	public String getComments() {
		return Comments;
	}

	@Override
	public String toString() {
		// gender.name().toLower()
		return super.toString() + "\t ... \t" + "PatientPersonalData [gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", woundSite="
				+ woundSite + ", telephoneNumber=" + telephoneNumber
				+ ", yearofDiagnosis=" + yearofDiagnosis + ", Comments="
				+ Comments + "]";
	}
	
	
}
