package utilities.generators;

import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;

public class ExpertPersonalDataGenerator {

	public static ExpertPersonalData generate(String userName) {
		String name = userName + "_Name";
		String family = userName + "_Family";
		return new ExpertPersonalData.Builder(userName, name, family).build();
	}
}
