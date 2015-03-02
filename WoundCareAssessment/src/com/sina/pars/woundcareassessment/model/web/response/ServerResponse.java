package com.sina.pars.woundcareassessment.model.web.response;

import enums.ServerResponseType;

public abstract class ServerResponse {
	private final ServerResponseType type;
	private final boolean isSuccessful;
	private final Object body;

	protected ServerResponse(ServerResponseType type, boolean isSuccessful,
			Object body) {
		this.type = type;
		this.isSuccessful = isSuccessful;
		this.body = body;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public Object getBody() {
		return body;
	}

	public ServerResponseType getType() {
		return type;
	}

}