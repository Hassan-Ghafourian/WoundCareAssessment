package utilities.generators;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Gender;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;

public class PatientPersonalDataGenerator {
	public static PatientPersonalData generate(String userName) {
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
}
