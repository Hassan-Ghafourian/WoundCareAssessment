package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.doc;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.sina.pars.woundcareassessment.model.constants.enums.data.WoundSite;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public class WoundDocDeserializer implements
		WoundCareJsonDeserializer<WoundDoc> {

	@Override
	public WoundDoc deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jRoot = arg0.getAsJsonObject();

		JsonObject jBradenAssessment = jRoot.get("bradenAssessment")
				.getAsJsonObject();
		final BradenAssessment bradenAssessment = gson.fromJson(
				jBradenAssessment, BradenAssessment.class);

		String jWoundSite = jRoot.get("woundSite").getAsString();
		final WoundSite woundSite = WoundSite.valueOf(jWoundSite);

		JsonArray jPaperList = jRoot.get("paperList").getAsJsonArray();
		Type listType = new TypeToken<ArrayList<WoundPaper>>() {
		}.getType();
		final ArrayList<WoundPaper> paperList = gson.fromJson(jPaperList,
				listType);

		// boolean isPersonal = jRoot.get("isPersonal").getAsBoolean(); << This
		// statement is not necessary,because default is "true" and is not used
		// in Builder.

		return new WoundDoc.Builder(bradenAssessment, woundSite, paperList)
				.build();
	}

}
