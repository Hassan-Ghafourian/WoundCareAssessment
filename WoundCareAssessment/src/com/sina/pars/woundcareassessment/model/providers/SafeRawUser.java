package com.sina.pars.woundcareassessment.model.providers;

import utilities.UserConverter;
import android.database.Cursor;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestType;
import com.sina.pars.woundcareassessment.model.constants.enums.userdao.EffectDestinationType;
import com.sina.pars.woundcareassessment.model.data.person.User;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClientFactory;

public class SafeRawUser {
	private String rawData;

	public static void getSafe(String userName) {
		String raw = "";
		Cursor cursor = queryLocal(userName);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			raw = cursor.getString(0);
			cursor.close();
			User user = new UserConverter().convert(User.class, raw);
			WebClient syncClient = new WebClientFactory.Builder(
					RequestType.Sync).user(user).build().getWebClient();
			syncClient.sendRequest();
		} else {
			return;
		}
	}

	private static Cursor queryLocal(String userName) {
		return UserDAOImplementer.getInstance().query(
				new UserDAOMethodsInput(EffectDestinationType.LOCAL, userName,
						null));
	}
}
