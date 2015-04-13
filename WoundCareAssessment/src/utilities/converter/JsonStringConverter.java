package utilities.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sina.pars.woundcareassessment.model.data.Data;

public interface JsonStringConverter {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	Data convert(String jsonString);
}
