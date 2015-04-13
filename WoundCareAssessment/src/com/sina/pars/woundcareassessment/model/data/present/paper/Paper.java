package com.sina.pars.woundcareassessment.model.data.present.paper;

import java.util.List;

import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;

public class Paper extends Data {

	private final String imageUri;
	private final List<Comment> commnetsList;

	protected Paper(String imageUri, List<Comment> commnetsList) {
		super();
		this.imageUri = imageUri;
		this.commnetsList = commnetsList;
	}

	public String getImageUri() {
		return imageUri;
	}

	public List<Comment> getCommnetsList() {
		return commnetsList;
	}

}
