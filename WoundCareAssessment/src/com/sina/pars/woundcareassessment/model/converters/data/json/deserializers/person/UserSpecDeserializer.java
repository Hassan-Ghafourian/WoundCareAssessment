package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.person;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.constants.ClassNames;
import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.person.UserSpec;
import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;

public class UserSpecDeserializer implements
		WoundCareJsonDeserializer<UserSpec> {

	@Override
	public UserSpec deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {

		JsonObject jObject = (JsonObject) arg0;
		
		JsonObject jPersonalData = jObject.get("personalData").getAsJsonObject();

		String className = jPersonalData.get("className").getAsString();
		PersonalData personalData;
		if (ClassNames.PATIENT_PERSONAL_DATA.equals(className)) {
			personalData = gson.fromJson(jObject.get("personalData"),
					PatientPersonalData.class);
		} else if (ClassNames.EXPERT_PERSONAL_DATA.equals(className)) {
			personalData = gson.fromJson(jObject.get("personalData"),
					ExpertPersonalData.class);
		} else {
			throw new IllegalArgumentException("Class [" + className
					+ "] is not of type PersonalData");
		}

		final Role role = Role.valueOf(jObject.get("role").getAsString());

		return new UserSpec.Builder(personalData, role).build();
	}

}
