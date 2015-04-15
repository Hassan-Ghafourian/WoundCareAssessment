package utilities.converters.serializers;

import utilities.converters.GsonProvider;

import com.google.gson.JsonSerializer;

public interface WoundCareJsonSerializer<T> extends JsonSerializer<T>,
		GsonProvider {
}
