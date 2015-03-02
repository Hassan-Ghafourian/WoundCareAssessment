package com.sina.pars.woundcareassessment.model.web.response;

import enums.ServerResponseType;

public class DownloadingResponse extends ServerResponse {

	protected DownloadingResponse(ServerResponseType type, boolean isSuccessful,
			Object body) {
		super(type, isSuccessful, body);
	}

}