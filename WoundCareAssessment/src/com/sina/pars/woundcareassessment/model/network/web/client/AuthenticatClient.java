package com.sina.pars.woundcareassessment.model.network.web.client;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.sina.pars.woundcareassessment.model.constants.enums.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.constants.enums.ServerResponseType;
import com.sina.pars.woundcareassessment.model.network.connection.Internetconnection;
import com.sina.pars.woundcareassessment.model.network.web.response.ResponseFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;

import de.greenrobot.event.EventBus;

public class AuthenticatClient implements WebClient {

	private final String userName;
	private final String password;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	protected AuthenticatClient(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public void sendRequest() {
		if (!Internetconnection.isDeviceOnline()) {
			publishResponse(ServerResponseType.AuthenticatingResponse,
					RequestStatus.ConnectionError, new Object());
		} else {
			new HttpTask().execute();
		}
	}

	@Override
	public void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body) {
		ServerResponse response = ResponseFactory.productResponse(
				serverResponseType, requestStatus, body);
		EventBus.getDefault().post(response);
	}

	class HttpTask extends AsyncTask<Void, String, Boolean> {
		@Override
		protected Boolean doInBackground(Void... unused) {
			SystemClock.sleep(2000);
			return true;
		}

		@Override
		protected void onProgressUpdate(String... item) {
		}

		@Override
		protected void onPostExecute(Boolean bool) {
			Role role = null;
			final String lowerCaseUserName = AuthenticatClient.this.userName
					.toLowerCase();
			if (lowerCaseUserName.contains("patient")) {
				role = Role.Patient;
			} else if (lowerCaseUserName.contains("expert")) {
				role = Role.Expert;
			} else if (lowerCaseUserName.contains("unregistered")) {
				role = Role.Unregistered;
			}
			publishResponse(ServerResponseType.AuthenticatingResponse,
					RequestStatus.OK, role);
		}
	}
}