package com.sina.pars.woundcareassessment.model.network.web.response;

import enums.RequestStatus;
import enums.ServerResponseType;

public class ResponseFactory {

	public static ServerResponse productResponse(ServerResponseType type,
			RequestStatus status, Object body) {
		ServerResponse serverResponse = null;
		switch (type) {
		case AuthenticatingResponse:
			serverResponse = new AuthenticatingResponse(type, status, body);
			break;
		case DownloadingResponse:
			serverResponse = new DownloadingResponse(type, status, body);
			break;
		case SyncResponse:
			serverResponse = new SyncResponse(type, status, body);
			break;
		default:
			break;
		}
		return serverResponse;
	}
}
