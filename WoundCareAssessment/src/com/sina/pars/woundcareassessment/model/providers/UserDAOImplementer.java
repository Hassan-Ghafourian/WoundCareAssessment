package com.sina.pars.woundcareassessment.model.providers;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;

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
		providerClient = App.getAppContext().getContentResolver()
				.acquireContentProviderClient(UserProviderMetaData.AUTHORITY);
		return null;
	}

	@Override
	public Cursor query(UserDAOMethodsInput userDAOMethodsInput) {

		return null;
	}

	@Override
	public int update(UserDAOMethodsInput userDAOMethodsInput) {

		return 0;
	}

}
