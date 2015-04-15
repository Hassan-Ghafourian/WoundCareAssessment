package utilities.converters;

import java.util.Date;

import utilities.converters.deserializers.DateDeserializer;
import utilities.converters.deserializers.bradenassessment.BradenAssessmentDeserializer;
import utilities.converters.deserializers.person.ExpertDeserializer;
import utilities.converters.deserializers.person.PatientDeserializer;
import utilities.converters.deserializers.person.UserSpecDeserializer;
import utilities.converters.deserializers.personal.ExpertPersonalDataDeserializer;
import utilities.converters.deserializers.personal.PatientPersonalDataDeserializer;
import utilities.converters.deserializers.present.comment.CommentDeserializer;
import utilities.converters.deserializers.present.doc.WoundDocDeserializer;
import utilities.converters.deserializers.present.folder.WoundFolderDeserializer;
import utilities.converters.deserializers.present.paper.WoundPaperDeserializer;
import utilities.converters.serializers.DataSerializer;
import utilities.converters.serializers.DateSerializer;
import utilities.converters.serializers.PatientPersonalDataSerializer;
import utilities.converters.serializers.PersonalDataSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

/**
 * We have to use the {@link #gson} that is provided by this interface to
 * serializing or deserializing classes with Gson.
 * 
 */
public interface GsonProvider {
	/**
	 * All serializer and deserializer classes are registered here in this
	 * instance of Gson.
	 */
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
