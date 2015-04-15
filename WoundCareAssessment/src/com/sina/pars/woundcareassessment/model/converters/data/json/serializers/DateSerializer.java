package com.sina.pars.woundcareassessment.model.converters.data.json.serializers;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
public class DateSerializer implements WoundCareJsonSerializer<Date> {
	
	@Override
	  public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");  
	    return new JsonPrimitive(sdf.format(date));
	  }

} 