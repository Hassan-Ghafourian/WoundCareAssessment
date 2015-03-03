package com.sina.pars.woundcareassessment.model.network.web.client;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.sina.pars.woundcareassessment.model.network.web.response.ResponseFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.SyncResponse;

import de.greenrobot.event.EventBus;
import enums.RequestStatus;
import enums.ServerResponseType;

public class SyncClient implements WebClient {

	/**
	 * 
	 * @param userName
	 * @return
	 */
	protected SyncClient(String userName) {
		// throw new UnsupportedOperationException();
	}

	@Override
	public void sendRequest() {
		new HttpTask().execute();
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
					.productResponse(ServerResponseType.SyncResponse,
							RequestStatus.OK, null);
			EventBus.getDefault().post(syncResponse);
		}
	}
}