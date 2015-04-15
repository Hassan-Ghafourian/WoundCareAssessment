package utilities.converters.serializers;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;

public class PatientPersonalDataSerializer implements
		WoundCareJsonSerializer<PatientPersonalData> {

	@Override
	public JsonElement serialize(PatientPersonalData patientPersonalData,
			Type arg1, JsonSerializationContext arg2) {
		PersonalData personalData = (PersonalData) patientPersonalData;
		String personalDataJson = gson.toJson(personalData, PersonalData.class);
		final JsonObject jsonObject = new JsonParser().parse(personalDataJson)
				.getAsJsonObject();

		jsonObject
				.addProperty("gender", patientPersonalData.getGender().name());
		jsonObject.addProperty("dateOfBirth",
				gson.toJson(patientPersonalData.getDateOfBirth(), Date.class));
		jsonObject.addProperty("address", patientPersonalData.getAddress());
		jsonObject.addProperty("telephoneNumber",
				patientPersonalData.getTelephoneNumber());
		jsonObject.addProperty("comments", patientPersonalData.getComments());

		return jsonObject;
	}

}
