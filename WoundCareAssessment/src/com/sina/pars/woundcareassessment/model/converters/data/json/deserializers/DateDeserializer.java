package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

public class DateDeserializer implements WoundCareJsonDeserializer<Date> {
	public Date deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = sdf.parse(json.getAsJsonPrimitive().getAsString());
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}