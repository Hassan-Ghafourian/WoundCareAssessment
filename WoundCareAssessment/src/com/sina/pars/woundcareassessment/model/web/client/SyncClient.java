package com.sina.pars.woundcareassessment.model.web.client;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.sina.pars.woundcareassessment.model.web.response.ResponseFactory;
import com.sina.pars.woundcareassessment.model.web.response.ServerResponse;
import com.sina.pars.woundcareassessment.model.web.response.SyncResponse;

import de.greenrobot.event.EventBus;
import enums.ServerResponseType;

public class SyncClient implements Client {

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SyncClient(String userName) {
		// throw new UnsupportedOperationException();
	}

	@Override
	public ServerResponse sendRequest() {
		new HttpTask().execute();
		return null;
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
					.productResponse(ServerResponseType.SyncResponse, true,
							null);
			EventBus.getDefault().post(syncResponse);
		}
	}
}