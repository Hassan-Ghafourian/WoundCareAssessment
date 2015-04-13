package utilities.converter.deserializer.personal;

import java.lang.reflect.Type;
import java.util.Date;

import utilities.converter.deserializer.WoundCareJsonDeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.constants.enums.data.Gender;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;

public class PatientPersonalDataDeserializer implements
		WoundCareJsonDeserializer<PatientPersonalData> {

	@Override
	public PatientPersonalData deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		
		JsonObject jObject = (JsonObject)arg0;
		
		String userName = jObject.get("userName").getAsString();
		String name = jObject.get("name").getAsString();
		String family = jObject.get("family").getAsString();
		Gender gender = Gender.valueOf(jObject.get("gender").getAsString());
		Date dateOfBirth = 
				gson.fromJson(jObject.get("dateOfBirth").getAsString(), Date.class)
//				new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L)
				;
		String address = jObject.get("address").getAsString();
		String telephoneNumber = jObject.get("telephoneNumber").getAsString();
		String comments = jObject.get("comments").getAsString();
		
		return new PatientPersonalData.Builder(gender, dateOfBirth, address,
				telephoneNumber, comments, userName, name, family).build();
	}
}
