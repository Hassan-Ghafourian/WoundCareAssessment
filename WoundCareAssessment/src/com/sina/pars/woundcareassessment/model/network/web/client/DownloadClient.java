package com.sina.pars.woundcareassessment.model.network.web.client;

import com.sina.pars.woundcareassessment.model.constants.enums.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.ServerResponseType;

public class DownloadClient implements WebClient {

	/**
	 * 
	 * @param userName
	 * @return
	 */
	protected DownloadClient(String userName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendRequest() {
	}

	@Override
	public void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body) {
		// TODO Auto-generated method stub

	}

}