package com.sina.pars.woundcareassessment.model.web.response;

import enums.RequestStatus;
import enums.ServerResponseType;

public abstract class ServerResponse {
	private final ServerResponseType type;
	private final Object body;
	private final RequestStatus status;

	protected ServerResponse(ServerResponseType type, RequestStatus status,
			Object body) {
		this.type = type;
		this.body = body;
		this.status = status;
	}

	public Object getBody() {
		return body;
	}

	public ServerResponseType getType() {
		return type;
	}

	/**
	 * 
	 * @return status of request
	 */
	public RequestStatus getStatus() {
		return status;
	}

}