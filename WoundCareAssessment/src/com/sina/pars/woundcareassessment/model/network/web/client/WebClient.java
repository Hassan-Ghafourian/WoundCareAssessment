package com.sina.pars.woundcareassessment.model.network.web.client;

import android.content.Context;

import com.sina.pars.woundcareassessment.application.App;
import com.sina.pars.woundcareassessment.model.constants.enums.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.ServerResponseType;

public interface WebClient {

	static final Context context = App.getAppContext();

	void sendRequest();

	void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body);
}