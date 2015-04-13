package com.sina.pars.woundcareassessment.model.data.present.doc;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.constants.enums.data.WoundSite;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public class WoundDoc extends Document<WoundPaper> {

	private final BradenAssessment bradenAssessment;
	private final WoundSite woundSite;
		
	public static class Builder {
		private final BradenAssessment bradenAssessment;
		private final WoundSite woundSite;
		private final ArrayList<WoundPaper> paperList;
		private boolean isPersonal = true;
		
		public Builder(BradenAssessment bradenAssessment, WoundSite woundSite,
				ArrayList<WoundPaper> paperList) {
			super();
			this.bradenAssessment = bradenAssessment;
			this.woundSite = woundSite;
			this.paperList = paperList;
		}
		
		public Builder isPersonal(boolean isPersonal) {
			this.isPersonal = isPersonal;
			return this;
		}

		public WoundDoc build(){
			return new WoundDoc(this);
		}

	}

	private WoundDoc(Builder builder) {
		super(builder.isPersonal,builder.paperList);
		this.bradenAssessment = builder.bradenAssessment;
		this.woundSite = builder.woundSite;
	}

	public BradenAssessment getBradenAssessment() {
		return bradenAssessment;
	}

	public WoundSite getWoundSite() {
		return woundSite;
	}

}
