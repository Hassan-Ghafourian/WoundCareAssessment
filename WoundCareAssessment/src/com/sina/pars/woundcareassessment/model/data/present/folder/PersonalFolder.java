package com.sina.pars.woundcareassessment.model.data.present.folder;

import java.util.List;

import com.sina.pars.woundcareassessment.model.data.present.doc.Document;

public class PersonalFolder extends Folder {
	private final List<Document> docsList;

	public PersonalFolder(List<Document> docsList) {
		super();
		this.docsList = docsList;
	}

	public List<Document> getDocsList() {
		return docsList;
	}

}
