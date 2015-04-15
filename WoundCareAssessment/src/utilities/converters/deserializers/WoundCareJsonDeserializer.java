package utilities.converters.deserializers;

import utilities.converters.GsonProvider;

import com.google.gson.JsonDeserializer;

public interface WoundCareJsonDeserializer<T> extends JsonDeserializer<T>,
		GsonProvider {
}
