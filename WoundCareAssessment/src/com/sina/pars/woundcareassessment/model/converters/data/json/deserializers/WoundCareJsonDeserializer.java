package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers;

import com.google.gson.JsonDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.GsonProvider;

public interface WoundCareJsonDeserializer<T> extends JsonDeserializer<T>,
		GsonProvider {
}
