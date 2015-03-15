package com.sina.pars.woundcareassessment.model.network.web.client;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;

public class DownloadClient implements WebClient {

	private final String userName;
	private final ID id;
	

	protected DownloadClient(String userName, ID id) {
		this.userName = userName;
		this.id = id;
	}

	@Override
	public void sendRequest() {
	}

	@Override
	public void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body, ID id) {
		// TODO Auto-generated method stub

	}

}