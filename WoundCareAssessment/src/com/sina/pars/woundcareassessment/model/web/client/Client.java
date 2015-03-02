package com.sina.pars.woundcareassessment.model.web.client;

import android.content.Context;

import com.sina.pars.woundcareassessment.application.App;
import com.sina.pars.woundcareassessment.model.web.response.ServerResponse;

public interface Client {

	static final Context context = App.getAppContext();
	ServerResponse sendRequest();

}