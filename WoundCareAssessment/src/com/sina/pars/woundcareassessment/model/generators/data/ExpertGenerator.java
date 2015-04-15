package com.sina.pars.woundcareassessment.model.generators.data;

import com.sina.pars.woundcareassessment.model.data.person.Expert;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.Folder;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class ExpertGenerator implements Generator<String, Expert> {

	private static final ExpertGenerator instance = new ExpertGenerator();

	private ExpertGenerator() {
	}

	@Override
	public Expert generate(String userName) {
		PersonalData pd = ExpertPersonalDataGenerator.getInstance()
				.generate(userName);
		Folder expertFolder = null;
		return new Expert.Builder(pd, expertFolder).build();
	}

	public static ExpertGenerator getInstance() {
		return instance;
	}

}
