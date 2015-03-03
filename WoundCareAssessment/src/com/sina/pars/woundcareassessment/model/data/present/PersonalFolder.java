package com.sina.pars.woundcareassessment.model.data.present;

import java.util.List;

public class PersonalFolder extends Folder {
	private final List<Document> docsList;

	protected PersonalFolder(List<Document> docsList) {
		super();
		this.docsList = docsList;
	}

	public List<Document> getDocsList() {
		return docsList;
	}

}
