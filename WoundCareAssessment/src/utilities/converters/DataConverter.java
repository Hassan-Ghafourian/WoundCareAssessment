package utilities.converters;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.sina.pars.woundcareassessment.model.data.Data;

public class DataConverter<T> implements Converter<T> {

	static Gson gson = GsonProvider.gson;

	@Override
	public T convert(Class<T> type, Object value) {
		if ((value.getClass().equals(String.class))
				&& (Data.class.isAssignableFrom(type))) {
			return convertJsonStringToData((String) value);
		} else if ((type.equals(String.class)) && (value instanceof Data)) {
			return conevertDataToJSONString((Data) value);
		} else {
			throw new IllegalArgumentException(
					"Illegal parameters in converter");
		}
	}

	private T conevertDataToJSONString(Data data) {
		String value = gson.toJson(data);
		return (T) value;
	}

	private T convertJsonStringToData(String jsonString) {
		// to deserialize a JSON by Google Gson,we need to detect class type of
		// deserializing destination:
		Class<T> clazz = getClassNameOfDataJsonString(jsonString);
		return gson.fromJson(jsonString, clazz);
	}

	/**
	 * All classes that extend
	 * {@link com.sina.pars.woundcareassessment.model.data.Data Data},have
	 * {@link com.sina.pars.woundcareassessment.model.data.Data#getClassName()
	 * className} field.This method return associated className from JSON
	 * serialized result of class that extends
	 * {@link com.sina.pars.woundcareassessment.model.data.Data Data}.
	 * 
	 * @param jsonString
	 *            String that is result of serializing a class that extends
	 *            {@link com.sina.pars.woundcareassessment.model.data.Data Data}
	 * @return
	 */
	private Class<T> getClassNameOfDataJsonString(String jsonString) {
		JsonElement jelement = new JsonParser().parse(jsonString);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonPrimitive jClassName = jobject.getAsJsonPrimitive("className");
		String className = jClassName.getAsString().trim();
		Class<T> clazz = null;
		try {
			clazz = (Class<T>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
	}

}
