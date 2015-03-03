package com.sina.pars.woundcareassessment.model.web.client;

import android.content.Context;

import com.sina.pars.woundcareassessment.application.App;

public interface WebClient {

	static final Context context = App.getAppContext();
	void sendRequest();

}