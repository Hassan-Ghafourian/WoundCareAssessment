package utilities.converters.deserializers.personal;

import java.lang.reflect.Type;

import utilities.converters.deserializers.WoundCareJsonDeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;

public class ExpertPersonalDataDeserializer implements
		WoundCareJsonDeserializer<ExpertPersonalData> {

	@Override
	public ExpertPersonalData deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {

		JsonObject jObject = (JsonObject) arg0;

		String userName = jObject.get("userName").getAsString();
		String name = jObject.get("name").getAsString();
		String family = jObject.get("family").getAsString();

		return new ExpertPersonalData.Builder(userName, name, family).build();

	}

}
