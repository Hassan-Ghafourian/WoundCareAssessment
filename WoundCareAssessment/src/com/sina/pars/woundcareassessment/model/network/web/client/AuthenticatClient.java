package com.sina.pars.woundcareassessment.model.network.web.client;

import java.util.Locale;

import utilities.id.ID;
import android.os.AsyncTask;
import android.os.SystemClock;

import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;
import com.sina.pars.woundcareassessment.model.network.connection.Internetconnection;
import com.sina.pars.woundcareassessment.model.network.web.response.ResponseFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;

import de.greenrobot.event.EventBus;

public class AuthenticatClient implements WebClient {

	private final String userName;
	private final String password;
	private final ID id;

	protected AuthenticatClient(String userName, String password, ID id) {
		this.userName = userName;
		this.password = password;
		this.id = id;
	}

	@Override
	public void sendRequest() {
		if (!Internetconnection.isDeviceOnline()) {
			publishResponse(ServerResponseType.AuthenticatingResponse,
					RequestStatus.ConnectionError, new Object(), id);
		} else {
			new HttpTask().execute();
		}
	}

	@Override
	public void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body, ID id) {
		ServerResponse response = ResponseFactory.productResponse(
				serverResponseType, requestStatus, body, id);
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
					.toLowerCase(Locale.getDefault());
			if (lowerCaseUserName.contains("patient")) {
				role = Role.Patient;
			} else if (lowerCaseUserName.contains("expert")) {
				role = Role.Expert;
			} else if (lowerCaseUserName.contains("unregistered")) {
				role = Role.Unregistered;
			}
			publishResponse(ServerResponseType.AuthenticatingResponse,
					RequestStatus.OK, role, id);
		}
	}
}