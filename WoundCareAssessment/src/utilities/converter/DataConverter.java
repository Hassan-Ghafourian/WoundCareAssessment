package utilities.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.sina.pars.woundcareassessment.model.data.Data;

public class DataConverter<T> implements Converter<T> {

	static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public T convert(Class<T> type, Object value) {
		// TODO check input parameters validation:
		if (value.getClass().equals(String.class)) {
			return (T) convertJSONStringToData((String) value);
		} else if (type.equals(String.class)) {
			return (T) gson.toJson(value);
		} else {
			throw new IllegalArgumentException(
					"Illegal parameters in converter");
		}
	}

	private String conevertDataToJSONString(Data data) {
		String value = gson.toJson(data);
		return value;
	}

	private Data convertJSONStringToData(String jsonString) {
		JsonStringConverter jsonStringConverter = getJsonStringConverter(jsonString);
		return jsonStringConverter.convert(jsonString);
	}

	private JsonStringConverter getJsonStringConverter(String jsonString) {
		JsonElement jelement = new JsonParser().parse(jsonString);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonPrimitive jClassName = jobject.getAsJsonPrimitive("className");
		String className = jClassName.getAsString().trim();
		if (Constants.PATIENT.equals(className)) {
			return null;
		} else {
			throw new UnsupportedOperationException();
		}
	}

}
