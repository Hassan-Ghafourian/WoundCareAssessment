package com.sina.pars.woundcareassessment.model.web.response;

import enums.ServerResponseType;

public class SyncResponse extends ServerResponse {

	protected SyncResponse(ServerResponseType type, boolean isSuccessful,
			Object body) {
		super(type, isSuccessful, body);
	}

}