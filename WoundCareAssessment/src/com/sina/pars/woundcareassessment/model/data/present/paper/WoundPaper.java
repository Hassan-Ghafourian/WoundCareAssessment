package com.sina.pars.woundcareassessment.model.data.present.paper;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;

public class WoundPaper extends Paper {

	private final String imageUri;
	private final ArrayList<Comment> commentList;
	
	public static class Builder {
		private final String imageUri;
		private final ArrayList<Comment> commentList;

		public Builder(String imageUri, ArrayList<Comment> commentList) {
			super();
			this.imageUri = imageUri;
			this.commentList = commentList;
		}

		public WoundPaper build(){
			return new WoundPaper(this);
		}

	}

	private WoundPaper(Builder builder) {
		super(builder.commentList);
		this.imageUri = builder.imageUri;
		this.commentList = builder.commentList;
	}

	public String getImageUri() {
		return imageUri;
	}

	public ArrayList<Comment> getCommentList() {
		return commentList;
	}

}
