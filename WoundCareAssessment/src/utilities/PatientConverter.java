package utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sina.pars.woundcareassessment.model.person.Patient;

public class PatientConverter implements Converter {

	private static final Gson gson = new Gson();

	@Override
	public <T> T convert(Class<T> type, Object value) {
		if ((type.equals(JsonObject.class))
				&& (value.getClass().equals(Patient.class))) {
			System.out.println("Patient Object to JSONObject");
		} else if ((type
				.equals(JsonArray.class))
				&& (value.getClass().equals(Patient[].class))) {
			System.out.println("Patient Array to JSONArray");
		} else if ((value.getClass().equals(JSONObject.class) || (value
				.getClass().equals(JsonObject.class))
				&& (type.equals(Patient.class)))) {
			System.out.println("JSONObject to Patient Object");
		} else if ((value.getClass().equals(JSONArray.class) || (value
				.getClass().equals(JsonArray.class))
				&& (type.equals(Patient[].class)))) {
			System.out.println("JSONArray to Patient Array");
		}

		return null;
	}
//	public static Patient convertPatientStringToPatientObject(String patientJSON) {
//		PatientPersonalData p = gson.fromJson(new JSONObject(patientJSON)
//				.getJSONObject("personalData").toString(),
//				PatientPersonalData.class);
//		return new Patient(p);
//	}
//
//	public static Patient convertPatientJSONObjectToPatientObject(
//			JSONObject patientJSONObject) {
//		PatientPersonalData p = gson.fromJson(
//				patientJSONObject.getJSONObject("personalData").toString(),
//				PatientPersonalData.class);
//		return new Patient(p);
//	}
//
//	public static Patient[] convertPatientStringArraytoPatientArray(
//			String patientArrayJSON) {
//		final JSONArray jsonArray = new JSONArray(patientArrayJSON);
//		Patient[] patientArray = new Patient[jsonArray.length()];
//		for (int i = 0; i < jsonArray.length(); i++) {
//			JSONObject row = jsonArray.getJSONObject(i);
//			patientArray[i] = convertPatientJSONObjectToPatientObject(row);
//		}
//		return patientArray;
//	}

}
