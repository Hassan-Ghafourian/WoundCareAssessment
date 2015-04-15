package com.sina.pars.woundcareassessment.model.generators.data;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.constants.enums.data.WoundSite;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class WoundDocList implements
		Generator<ArrayList<WoundPaper>, ArrayList<WoundDoc>> {

	private static final WoundDocList instance = new WoundDocList();

	@Override
	public ArrayList<WoundDoc> generate(ArrayList<WoundPaper> woundPaperList) {
		ArrayList<WoundDoc> woundDocList = new ArrayList<WoundDoc>();
		BradenAssessment bradenAssessment = new BradenAssessment.Builder()
				.build();
		woundDocList.add(new WoundDoc.Builder(bradenAssessment, WoundSite.ARM,
				woundPaperList).build());
		woundDocList.add(new WoundDoc.Builder(bradenAssessment, WoundSite.NECK,
				woundPaperList).build());
		return woundDocList;
	}

	public static WoundDocList getInstance() {
		return instance;
	}

	private WoundDocList() {
	}

}
