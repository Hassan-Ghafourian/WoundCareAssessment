package com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.folder;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.WoundCareJsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;

public class WoundFolderDeserializer implements
		WoundCareJsonDeserializer<WoundFolder> {

	@Override
	public WoundFolder deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jRoot = arg0.getAsJsonObject();

		JsonArray jDocList = jRoot.get("docList").getAsJsonArray();
		Type listType = new TypeToken<ArrayList<WoundDoc>>() {
		}.getType();
		final ArrayList<WoundDoc> docList = gson.fromJson(jDocList, listType);

		// boolean isPersonal = jRoot.get("isPersonal").getAsBoolean(); << This
		// statement is not necessary,because default is "true" and is not used in Builder.

		return new WoundFolder.Builder(docList).build();
	}

}
