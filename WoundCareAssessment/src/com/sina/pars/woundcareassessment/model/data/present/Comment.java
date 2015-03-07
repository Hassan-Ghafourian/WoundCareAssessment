package com.sina.pars.woundcareassessment.model.data.present;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.person.UserSpec;

public class Comment extends Data{

	private final String text;
	private final Date date;
	private final UserSpec ownerSpec;

	protected Comment(String text, Date date, UserSpec ownerSpec) {
		super();
		this.text = text;
		this.date = date;
		this.ownerSpec = ownerSpec;
	}

	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public UserSpec getOwner() {
		return ownerSpec;
	}

}
