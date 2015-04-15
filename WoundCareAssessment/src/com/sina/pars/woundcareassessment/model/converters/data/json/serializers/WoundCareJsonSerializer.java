package com.sina.pars.woundcareassessment.model.converters.data.json.serializers;

import com.google.gson.JsonSerializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.GsonProvider;

public interface WoundCareJsonSerializer<T> extends JsonSerializer<T>,
		GsonProvider {
}
