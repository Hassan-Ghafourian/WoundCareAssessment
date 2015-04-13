package com.sina.pars.woundcareassessment.model.data.present.comment;

import java.util.Date;

import com.sina.pars.woundcareassessment.model.data.Data;
import com.sina.pars.woundcareassessment.model.data.person.UserSpec;

public class Comment extends Data{

	private final String text;
	private final Date date;
	private final UserSpec ownerSpec;

	public static class Builder {
		private final String text;
		private final Date date;
		private final UserSpec ownerSpec;

		public Builder(String text, Date date, UserSpec ownerSpec) {
			this.text = text;
			this.date = date;
			this.ownerSpec = ownerSpec;
		}
		
		public Comment build(){
			return new Comment(this);
		}

	}
	
	private Comment(Builder builder) {
		super();
		this.text = builder.text;
		this.date = builder.date;
		this.ownerSpec = builder.ownerSpec;
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
