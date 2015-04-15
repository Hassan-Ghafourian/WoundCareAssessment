package utilities.converters.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.sina.pars.woundcareassessment.model.data.Data;

public class DataSerializer implements WoundCareJsonSerializer<Data> {

	@Override
	public JsonElement serialize(Data data, Type arg1,
			JsonSerializationContext arg2) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("className", data.getClassName());
		
		return jsonObject;
	}

}
