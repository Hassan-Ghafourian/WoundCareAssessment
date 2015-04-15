package com.sina.pars.woundcareassessment.model.converters.data.json;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.DateDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.bradenassessment.BradenAssessmentDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.person.ExpertDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.person.PatientDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.person.UserSpecDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.personal.ExpertPersonalDataDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.personal.PatientPersonalDataDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.comment.CommentDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.doc.WoundDocDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.folder.WoundFolderDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.deserializers.present.paper.WoundPaperDeserializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.serializers.DataSerializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.serializers.DateSerializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.serializers.PatientPersonalDataSerializer;
import com.sina.pars.woundcareassessment.model.converters.data.json.serializers.PersonalDataSerializer;
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
