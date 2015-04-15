package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.bradenassessment;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;

public class BradenAssessmentDeserializer implements
		WoundCareJsonDeserializer<BradenAssessment> {

	@Override
	public BradenAssessment deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {

		JsonObject jRoot = arg0.getAsJsonObject();

		float sensoryPerceptionAssessment = jRoot.get(
				"sensoryPerceptionAssessment").getAsFloat();
		float moistureAssessment = jRoot.get("moistureAssessment").getAsFloat();
		float activityAssessment = jRoot.get("activityAssessment").getAsFloat();
		float mobilityAssessment = jRoot.get("mobilityAssessment").getAsFloat();
		float nutritionAssessment = jRoot.get("nutritionAssessment")
				.getAsFloat();
		float frictionAndShearAssessment = jRoot.get(
				"frictionAndShearAssessment").getAsFloat();

		return new BradenAssessment.Builder()
				.setActivityAssessment(activityAssessment)
				.setFrictionAndShearAssessment(frictionAndShearAssessment)
				.setMobilityAssessment(mobilityAssessment)
				.setMoistureAssessment(moistureAssessment)
				.setNutritionAssessment(nutritionAssessment)
				.setSensoryPerceptionAssessment(sensoryPerceptionAssessment)
				.build();
	}
}
