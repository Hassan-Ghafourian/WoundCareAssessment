package com.sina.pars.woundcareassessment.model.network.web.client;

import utilities.id.ID;
import android.content.Context;

import com.sina.pars.woundcareassessment.application.App;
import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

public interface WebClient {

	static final Context CONTEXT = App.getAppContext();

	void sendRequest();

	void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body, ID id);
}