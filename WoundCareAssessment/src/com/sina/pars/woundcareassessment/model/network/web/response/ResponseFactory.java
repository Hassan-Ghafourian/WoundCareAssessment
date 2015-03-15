package com.sina.pars.woundcareassessment.model.network.web.response;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

public class ResponseFactory {

	public static ServerResponse productResponse(ServerResponseType type,
			RequestStatus status, Object body, ID id) {
		ServerResponse serverResponse = null;
		switch (type) {
		case AuthenticatingResponse:
			serverResponse = new AuthenticatingResponse(type, status, body,
					id);
			break;
		case DownloadingResponse:
			serverResponse = new DownloadingResponse(type, status, body, id);
			break;
		case SyncResponse:
			serverResponse = new SyncResponse(type, status, body, id);
			break;
		default:
			break;
		}
		return serverResponse;
	}
}
