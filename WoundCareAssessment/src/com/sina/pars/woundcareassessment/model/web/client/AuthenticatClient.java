package com.sina.pars.woundcareassessment.model.web.client;

import com.sina.pars.woundcareassessment.model.web.response.ServerResponse;

public class AuthenticatClient implements Client{

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return 
	 */
	public AuthenticatClient(String userName, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ServerResponse sendRequest() {
		return null;
	}

}