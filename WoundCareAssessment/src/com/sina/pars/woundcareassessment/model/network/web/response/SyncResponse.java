package com.sina.pars.woundcareassessment.model.network.web.response;

import com.sina.pars.woundcareassessment.model.constants.enums.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.ServerResponseType;

public class SyncResponse extends ServerResponse {

	protected SyncResponse(ServerResponseType type, RequestStatus status,
			Object body) {
		super(type, status, body);
	}

}