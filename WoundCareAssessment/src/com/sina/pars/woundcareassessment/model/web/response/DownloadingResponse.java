package com.sina.pars.woundcareassessment.model.web.response;

import enums.RequestStatus;
import enums.ServerResponseType;

public class DownloadingResponse extends ServerResponse {

	protected DownloadingResponse(ServerResponseType type,
			RequestStatus status, Object body) {
		super(type, status, body);
	}

}