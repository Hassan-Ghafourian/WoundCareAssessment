package com.sina.pars.woundcareassessment.model.providers;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;

import com.sina.pars.woundcareassessment.application.App;

public class UserDAOImplementer implements UserDAO {

	ContentProviderClient providerClient;

	public UserDAOImplementer() {

	}

	@Override
	public int delete(UserDAOMethodsInput userDAOMethodsInput) {

		return 0;
	}

	@Override
	public Uri insert(UserDAOMethodsInput userDAOMethodsInput) {
		return null;
	}

	@Override
	public Cursor query(UserDAOMethodsInput userDAOMethodsInput) {
		switch (userDAOMethodsInput.getEffectDestinationType()) {
		case LOCAL:
			providerClient = App
					.getAppContext()
					.getContentResolver()
					.acquireContentProviderClient(
							LocalUserProviderMetaData.AUTHORITY);
			try {
				return providerClient
						.query(Uri
								.parse(LocalUserProviderMetaData.LocalUserTableMetaData.CONTENT_URI
										+ "/ttt"), null, null, null, null);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		case REMOTE:
			break;

		default:
			throw new IllegalArgumentException(userDAOMethodsInput
					.getEffectDestinationType().toString()
					+ "is not legal.It must be REMOTE or LOCAL");
		}
		return null;
	}

	@Override
	public int update(UserDAOMethodsInput userDAOMethodsInput) {

		return 0;
	}

}
