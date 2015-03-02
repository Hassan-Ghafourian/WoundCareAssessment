package com.sina.pars.woundcareassessment.model.web.response;

import enums.ServerResponseType;

public class ResponseFactory {

	public static ServerResponse productResponse(ServerResponseType type,
			boolean isSuccessful, Object body) {
		ServerResponse serverResponse = null;
		switch (type) {
		case AuthenticatingResponse:
			serverResponse = new AuthenticatingResponse(type, isSuccessful,
					body);
			break;
		case DownloadingResponse:
			serverResponse = new DownloadingResponse(type, isSuccessful, body);
			break;
		case SyncResponse:
			serverResponse = new SyncResponse(type, isSuccessful, body);
			break;
		default:
			break;
		}
		return serverResponse;
	}
}
