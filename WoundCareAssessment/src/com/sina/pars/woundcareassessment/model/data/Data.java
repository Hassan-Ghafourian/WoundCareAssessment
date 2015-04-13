package com.sina.pars.woundcareassessment.model.data;

public abstract class Data {
	String className;

	protected Data() {
		this.className = this.getClass().getName();
	}

	public String getClassName() {
		return className;
	}
}
