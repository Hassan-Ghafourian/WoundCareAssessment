package com.sina.pars.woundcareassessment.model.generators.data;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class WoundPaperList implements
		Generator<ArrayList<Comment>, ArrayList<WoundPaper>> {

	private final static WoundPaperList instance = new WoundPaperList();

	@Override
	public ArrayList<WoundPaper> generate(ArrayList<Comment> commentList) {
		ArrayList<WoundPaper> paperList = new ArrayList<WoundPaper>();
		String imageUri = "some URI";
		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		// paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		// paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		// paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		return paperList;
	}

	public static WoundPaperList getInstance() {
		return instance;
	}

	private WoundPaperList() {
	}

}
