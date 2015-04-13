package com.sina.pars.woundcareassessment.model.data.present.folder;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;

public class WoundFolder extends Folder<WoundDoc> {

	public static class Builder {
		private final ArrayList<WoundDoc> docList;
		private boolean isPersonal = true;

		public Builder(ArrayList<WoundDoc> docList) {
			super();
			this.docList = docList;
		}

		public Builder isPersonal(boolean isPersonal) {
			this.isPersonal = isPersonal;
			return this;
		}
		
		public WoundFolder build() {
			return new WoundFolder(this);
		}

	}

	private WoundFolder(Builder builder) {
		super(builder.isPersonal, builder.docList);
	}

}
