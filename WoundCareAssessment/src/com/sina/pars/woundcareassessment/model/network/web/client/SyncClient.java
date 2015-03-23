package com.sina.pars.woundcareassessment.model.network.web.client;

import utilities.id.ID;
import android.os.AsyncTask;
import android.os.SystemClock;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestStatus;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;
import com.sina.pars.woundcareassessment.model.data.person.User;
import com.sina.pars.woundcareassessment.model.network.connection.Internetconnection;
import com.sina.pars.woundcareassessment.model.network.web.response.ResponseFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.SyncResponse;

import de.greenrobot.event.EventBus;

public class SyncClient implements WebClient {

	private final User user;
	private final ID id;

	
	protected SyncClient(User user, ID id) {
		this.user = user;
		this.id = id;
	}

	@Override
	public void sendRequest() {
		if (!Internetconnection.isDeviceOnline()) {
			publishResponse(ServerResponseType.SYNC_RESPONSE,
					RequestStatus.CONNECTION_ERROR, new Object(), id);
		} else {
			new HttpTask().execute();
		}
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
			SyncResponse syncResponse = (SyncResponse) ResponseFactory
					.productResponse(ServerResponseType.SYNC_RESPONSE,
							RequestStatus.OK, user,id);
			EventBus.getDefault().post(syncResponse);
		}
	}

	@Override
	public void publishResponse(ServerResponseType serverResponseType,
			RequestStatus requestStatus, Object body, ID id) {
		// TODO Auto-generated method stub

	}
}