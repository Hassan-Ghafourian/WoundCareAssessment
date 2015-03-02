package com.sina.pars.woundcareassessment.model.web.response;

import enums.ServerResponseType;

public class AuthenticatingResponse extends ServerResponse {

	protected AuthenticatingResponse(ServerResponseType type,
			boolean isSuccessful, Object body) {
		super(type, isSuccessful, body);
	}

	
}