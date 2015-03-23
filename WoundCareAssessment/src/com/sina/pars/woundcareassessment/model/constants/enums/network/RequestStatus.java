package com.sina.pars.woundcareassessment.model.constants.enums.network;

/**
 * 
 * displays status of request.
 */
public enum RequestStatus {
	/**
	 * successful request
	 */
	OK,

	CREATED,

	ACCEPTED,
	/**
	 * URI you provided in a request does not exist
	 */
	NOT_FOUND_ERROR,
	/**
	 * incomplete error about sync
	 */
	INCOMPLETE_ERROR,
	/**
	 * network connection error
	 */
	CONNECTION_ERROR,

	UNKNOWN_ERROR
}
