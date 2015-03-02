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
	public int delete() {
		
		return 0;
	}

	@Override
	public Uri insert() {
		providerClient = App.getAppContext().getContentResolver()
				.acquireContentProviderClient(UserProviderConstants.AUTHORITY);
		return null;
	}

	@Override
	public Cursor query() {

		return null;
	}

	@Override
	public int update() {

		return 0;
	}

}
