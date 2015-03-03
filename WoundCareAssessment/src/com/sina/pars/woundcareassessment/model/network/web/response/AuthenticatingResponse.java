package com.sina.pars.woundcareassessment.model.network.web.response;

import enums.RequestStatus;
import enums.ServerResponseType;

public class AuthenticatingResponse extends ServerResponse {

	protected AuthenticatingResponse(ServerResponseType type,
			RequestStatus status, Object body) {
		super(type, status, body);
	}

}