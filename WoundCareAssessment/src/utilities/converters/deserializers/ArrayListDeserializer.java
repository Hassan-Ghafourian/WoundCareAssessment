package utilities.converters.deserializers;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class ArrayListDeserializer<YourClass> implements
		WoundCareJsonDeserializer<ArrayList<YourClass>> {

	@Override
	public ArrayList<YourClass> deserialize(JsonElement arg0, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {

		final JsonArray jsonArray = arg0.getAsJsonArray();

		// JsonElement jsonComment;
		// Comment comment;
		// for (int i = 0; i < jsonCommentList.size(); i++) {
		// jsonComment = jsonCommentList.get(i);
		// comment = gson.fromJson(jsonComment, Comment.class);
		// commentList.add(comment);
		// }

		Type listType = new TypeToken<ArrayList<YourClass>>() {
		}.getType();
		ArrayList<YourClass> yourClassList = gson.fromJson(jsonArray,
				listType);

		return yourClassList;
	}

}
