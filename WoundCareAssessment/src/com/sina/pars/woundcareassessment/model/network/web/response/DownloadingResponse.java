package com.sina.pars.woundcareassessment.model.network.web.response;

import com.sina.pars.woundcareassessment.model.constants.enums.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.ServerResponseType;

public class DownloadingResponse extends ServerResponse {

	protected DownloadingResponse(ServerResponseType type,
			RequestStatus status, Object body) {
		super(type, status, body);
	}

}