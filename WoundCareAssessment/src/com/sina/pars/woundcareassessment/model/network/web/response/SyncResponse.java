package com.sina.pars.woundcareassessment.model.network.web.response;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

public class SyncResponse extends ServerResponse {

	protected SyncResponse(ServerResponseType type, RequestStatus status,
			Object body, ID id) {
		super(type, status, body, id);
	}

}