package utilities.converter.deserializer;

import java.util.Date;

import utilities.converter.deserializer.bradenassessment.BradenAssessmentDeserializer;
import utilities.converter.deserializer.person.ExpertDeserializer;
import utilities.converter.deserializer.person.PatientDeserializer;
import utilities.converter.deserializer.person.UserSpecDeserializer;
import utilities.converter.deserializer.personal.ExpertPersonalDataDeserializer;
import utilities.converter.deserializer.personal.PatientPersonalDataDeserializer;
import utilities.converter.deserializer.present.comment.CommentDeserializer;
import utilities.converter.deserializer.present.doc.WoundDocDeserializer;
import utilities.converter.deserializer.present.folder.WoundFolderDeserializer;
import utilities.converter.deserializer.present.paper.WoundPaperDeserializer;
import utilities.converter.serializer.DataSerializer;
import utilities.converter.serializer.DateSerializer;
import utilities.converter.serializer.PatientPersonalDataSerializer;
import utilities.converter.serializer.PersonalDataSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.person.Expert;
import com.sina.pars.woundcareassessment.model.data.person.Patient;
import com.sina.pars.woundcareassessment.model.data.person.UserSpec;
import com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData;
import com.sina.pars.woundcareassessment.model.data.personal.PersonalData;
import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.folder.WoundFolder;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public interface WoundCareJsonDeserializer<T> extends JsonDeserializer<T> {
	static final Gson gson = new GsonBuilder()
			.registerTypeAdapter(Date.class, new DateSerializer())
			.registerTypeAdapter(Date.class, new DateDeserializer())
			.setPrettyPrinting()
			.registerTypeAdapter(Data.class, new DataSerializer())
			.registerTypeAdapter(PersonalData.class,
					new PersonalDataSerializer())
			.registerTypeAdapter(ExpertPersonalData.class,
					new ExpertPersonalDataDeserializer())
			.registerTypeAdapter(UserSpec.class, new UserSpecDeserializer())
			.registerTypeAdapter(Comment.class, new CommentDeserializer())
			// .registerTypeAdapter(ArrayList<?>.class,
			// new ArrayListDeserializer())
			.registerTypeAdapter(WoundPaper.class, new WoundPaperDeserializer())
			.registerTypeAdapter(BradenAssessment.class,
					new BradenAssessmentDeserializer())
			.registerTypeAdapter(WoundDoc.class, new WoundDocDeserializer())
			.registerTypeAdapter(WoundFolder.class,
					new WoundFolderDeserializer())
			.registerTypeAdapter(Patient.class, new PatientDeserializer())
			.registerTypeAdapter(Expert.class, new ExpertDeserializer())
			.registerTypeAdapter(PatientPersonalData.class,
					new PatientPersonalDataDeserializer())
			.registerTypeAdapter(PatientPersonalData.class,
					new PatientPersonalDataSerializer()).create();
}
