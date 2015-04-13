package utilities.converter.deserializer.present.paper;

import java.lang.reflect.Type;
import java.util.ArrayList;

import utilities.converter.deserializer.WoundCareJsonDeserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public class WoundPaperDeserializer implements
		WoundCareJsonDeserializer<WoundPaper> {

	@Override
	public WoundPaper deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jRoot = arg0.getAsJsonObject();
		JsonArray jCommentArray = jRoot.get("commentList").getAsJsonArray();

		final String imageUri = jRoot.get("imageUri").getAsString();

		Type listType = new TypeToken<ArrayList<Comment>>() {
		}.getType();
		final ArrayList<Comment> commentList = gson.fromJson(jCommentArray,
				listType);

		return new WoundPaper.Builder(imageUri, commentList).build();
	}

}
