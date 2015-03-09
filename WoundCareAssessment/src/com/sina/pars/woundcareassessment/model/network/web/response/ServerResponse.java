package com.sina.pars.woundcareassessment.model.network.web.response;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

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

	@Override
	public String toString() {
		return "ServerResponse [type=" + type + ", body=" + body + ", status="
				+ status + "]";
	}

}