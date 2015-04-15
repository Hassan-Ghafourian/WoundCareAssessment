package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.comment;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.person.UserSpec;
import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;

public class CommentDeserializer implements WoundCareJsonDeserializer<Comment> {

	@Override
	public Comment deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		
		JsonObject jRoot = arg0.getAsJsonObject();
		JsonObject jUserSpec = jRoot.get("ownerSpec").getAsJsonObject();
		
		final String text = jRoot.get("text").getAsString();
		final Date date = gson.fromJson(jRoot.get("date").getAsString(), Date.class);
		final UserSpec ownerSpec = gson.fromJson(jUserSpec, UserSpec.class);
		
		return new Comment.Builder(text, date, ownerSpec).build();
	}

}
