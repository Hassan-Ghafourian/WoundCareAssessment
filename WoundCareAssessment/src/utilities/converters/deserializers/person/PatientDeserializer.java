package utilities.converters.deserializers.person;

import java.lang.reflect.Type;

import utilities.converters.deserializers.WoundCareJsonDeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.data.person.Patient;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;

public class PatientDeserializer implements WoundCareJsonDeserializer<Patient> {

	@Override
	public Patient deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jRoot = arg0.getAsJsonObject();
		JsonObject jPersonalData = jRoot.get("personalData").getAsJsonObject();
		JsonObject jFolder = jRoot.get("folder").getAsJsonObject();

		final PatientPersonalData patientPersonalData = gson.fromJson(jPersonalData,
				PatientPersonalData.class);
		final WoundFolder woundFolder = gson.fromJson(jFolder,
				WoundFolder.class);

		return new Patient.Builder(patientPersonalData, woundFolder).build();
	}

}
