package utilities.generators;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.person.Patient;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;

public class PatientGenerator {
	public static Patient generate(String userName) {
		PersonalData pd = PatientPersonalDataGenerator.generate(userName);
//		pd.
		ArrayList<WoundDoc> docsList = new ArrayList<WoundDoc>();
		WoundFolder woundFolder = new WoundFolder.Builder(docsList).build();
		return new Patient.Builder(pd, woundFolder).build();
	}
}
