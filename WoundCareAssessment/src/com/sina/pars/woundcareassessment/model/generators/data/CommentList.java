package com.sina.pars.woundcareassessment.model.generators.data;

import java.util.ArrayList;
import java.util.Date;

import com.sina.pars.woundcareassessment.model.data.person.UserSpec;
import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;
import com.sina.pars.woundcareassessment.model.generators.Generator;

public final class CommentList implements Generator<UserSpec, ArrayList<Comment>> {

	private static final CommentList instance = new CommentList();

	private CommentList() {
	}

	@Override
	public ArrayList<Comment> generate(UserSpec pSpec) {
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		commentList.add(new Comment.Builder("1", new Date(), pSpec).build());
		commentList.add(new Comment.Builder("2", new Date(), pSpec).build());
		commentList.add(new Comment.Builder("3", new Date(), pSpec).build());
		// commentList.add(new Comment.Builder("4",new Date(), pSpec).build());
		// commentList.add(new Comment.Builder("5",new Date(), pSpec).build());
		// commentList.add(new Comment.Builder("6",new Date(), pSpec).build());
		return commentList;
	}

	public static CommentList getInstance() {
		return instance;
	}

}
