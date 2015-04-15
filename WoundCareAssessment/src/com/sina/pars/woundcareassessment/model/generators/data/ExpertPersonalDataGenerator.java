package com.sina.pars.woundcareassessment.model.generators.data;

import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class ExpertPersonalDataGenerator implements
		Generator<String, ExpertPersonalData> {

	private static final ExpertPersonalDataGenerator instance = new ExpertPersonalDataGenerator();

	private ExpertPersonalDataGenerator() {
	}

	@Override
	public ExpertPersonalData generate(String userName) {
		String name = userName + "_Name";
		String family = userName + "_Family";
		return new ExpertPersonalData.Builder(userName, name, family).build();
	}

	public static ExpertPersonalDataGenerator getInstance() {
		return instance;
	}
}
