package utilities.generators;

import com.sina.pars.woundcareassessment.model.data.person.Expert;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.Folder;

public class ExpertGenerator {
	
	public static Expert generate(String userName){
		PersonalData pd = ExpertPersonalDataGenerator.generate(userName);
		Folder expertFolder = null;
		return new Expert.Builder(pd, expertFolder).build();
	}
}
