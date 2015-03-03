package enums;

/**
 * 
 * displays status of request.
 */
public enum RequestStatus {
	/**
	 * successful request
	 */
	OK,

	Created,

	Accepted,
	/**
	 * URI you provided in a request does not exist
	 */
	NotFoundError,
	/**
	 * incomplete error about sync
	 */
	IncompleteError,
	/**
	 * network connection error
	 */
	ConnectionError,

	UnknownError
}
