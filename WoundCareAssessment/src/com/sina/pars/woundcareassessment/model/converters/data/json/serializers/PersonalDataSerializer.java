package com.sina.pars.woundcareassessment.model.converters.data.json.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;

public class PersonalDataSerializer implements
		WoundCareJsonSerializer<PersonalData> {

	@Override
	public JsonElement serialize(PersonalData personalData, Type arg1,
			JsonSerializationContext arg2) {
		Data data = (Data) personalData;
		String dataJson = gson.toJson(data, Data.class);
		final JsonObject jsonObject = new JsonParser().parse(dataJson)
				.getAsJsonObject();

		jsonObject.addProperty("userName", personalData.getUserName());
		jsonObject.addProperty("name", personalData.getName());
		jsonObject.addProperty("family", personalData.getFamily());

		return jsonObject;
	}

}
