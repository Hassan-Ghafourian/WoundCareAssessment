package com.sina.pars.woundcareassessment.model.data.present.folder;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.present.doc.Document;

public abstract class Folder<T extends Document<?>> extends Data {
	private final boolean isPersonal;
	private final ArrayList<T> docList;

	protected Folder(boolean isPersonal, ArrayList<T> docList) {
		super();
		this.isPersonal = isPersonal;
		this.docList = docList;
	}

	public boolean isPersonal() {
		return isPersonal;
	}

	public ArrayList<T> getDocList() {
		return docList;
	}
	
}
