package com.sina.pars.woundcareassessment.model.generators.data;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.person.Patient;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class PatientGenerator implements Generator<String, Patient> {

	private static final PatientGenerator instance = new PatientGenerator();

	@Override
	public Patient generate(String userName) {
		PersonalData pd = PatientPersonalDataGenerator.getInstance().generate(
				userName);
		// pd.
		ArrayList<WoundDoc> docsList = new ArrayList<WoundDoc>();
		WoundFolder woundFolder = new WoundFolder.Builder(docsList).build();
		return new Patient.Builder(pd, woundFolder).build();
	}

	public static PatientGenerator getInstance() {
		return instance;
	}

	private PatientGenerator() {
	}

}
