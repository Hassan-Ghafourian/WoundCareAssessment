package com.sina.pars.woundcareassessment.model.network.web.response;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

public abstract class ServerResponse {
	private final ServerResponseType type;
	private final Object body;
	private final RequestStatus status;
	private final ID id;

	protected ServerResponse(ServerResponseType type, RequestStatus status,
			Object body, ID id) {
		this.type = type;
		this.body = body;
		this.status = status;
		this.id = id;
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

	public ID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ServerResponse [type=" + type + ", body=" + body + ", status="
				+ status + "]";
	}

}