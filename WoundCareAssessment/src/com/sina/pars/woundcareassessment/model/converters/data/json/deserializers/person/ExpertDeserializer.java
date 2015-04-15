package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.person;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.person.Expert;
import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.Folder;

public class ExpertDeserializer implements WoundCareJsonDeserializer<Expert> {

	@Override
	public Expert deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jRoot = arg0.getAsJsonObject();
		JsonObject jPersonalData = jRoot.get("personalData").getAsJsonObject();

		final PersonalData personalData = gson.fromJson(jPersonalData,
				ExpertPersonalData.class);
		final Folder<?> folder = null; // now we have not any folder that is
										// specified for "Expert",so we use
										// "null"
		return new Expert.Builder(personalData, folder).build();
	}

}
