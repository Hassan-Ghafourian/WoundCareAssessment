package com.sina.pars.woundcareassessment.model.data.present.doc;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.present.paper.Paper;

public abstract class Document<T extends Paper> extends Data {
	private final boolean isPersonal;
	private final ArrayList<T> paperList;

	protected Document(boolean isPersonal, ArrayList<T> paperList) {
		super();
		this.isPersonal = isPersonal;
		this.paperList = paperList;
	}

	public boolean isPersonal() {
		return isPersonal;
	}

	public ArrayList<T> getPaperList() {
		return paperList;
	}

}
