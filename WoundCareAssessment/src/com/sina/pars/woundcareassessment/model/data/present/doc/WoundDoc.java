package com.sina.pars.woundcareassessment.model.data.present.doc;

import java.util.List;

import com.sina.pars.woundcareassessment.model.constants.enums.data.WoundSite;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.present.paper.Paper;

public class WoundDoc extends Document {

	private final BradenAssessment bradenAssessment;
	private final WoundSite woundSite;
	private final List<Paper> papersList;

	protected WoundDoc(BradenAssessment bradenAssessment, WoundSite woundSite,
			List<Paper> papersList) {
		super();
		this.bradenAssessment = bradenAssessment;
		this.woundSite = woundSite;
		this.papersList = papersList;
	}

	public BradenAssessment getBradenAssessment() {
		return bradenAssessment;
	}

	public WoundSite getWoundSite() {
		return woundSite;
	}

	public List<Paper> getPapersList() {
		return papersList;
	}

}