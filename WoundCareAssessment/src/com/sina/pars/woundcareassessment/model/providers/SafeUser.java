package com.sina.pars.woundcareassessment.model.providers;

import utilities.id.ID;
import android.database.Cursor;

import com.sina.pars.woundcareassessment.model.constants.enums.userdao.EffectDestinationType;
import com.sina.pars.woundcareassessment.model.converters.data.DataConverter;
import com.sina.pars.woundcareassessment.model.data.person.User;

public class SafeUser {

	/**
	 * posts associated <b>safe</b> "user" instance to client.
	 * 
	 * @param userName
	 */
	public static void getSafe(String userName, ID id) {
		String raw = "";
		Cursor cursor = queryLocal(userName, id);
		if (cursor.getCount() != 0) {
			cursor.moveToFirst();
			raw = cursor.getString(0);
			cursor.close();
//			User user = new UserConverter().convert(User.class, raw);
			User user = new DataConverter<User>().convert(User.class, raw);
			syncUser(user, id);
		} else {
			queryRemote(userName, id);
			return;
		}
	}

	private static Cursor queryLocal(String userName, ID id) {
		return UserDAOImplementer.getInstance().query(
				new UserDAOMethodsInput(id, EffectDestinationType.LOCAL,
						userName, null));
	}
	
	private static Cursor queryRemote(String userName, ID id) {
		return UserDAOImplementer.getInstance().query(
				new UserDAOMethodsInput(id, EffectDestinationType.REMOTE,
						userName, null));
	}

	private static void syncUser(User user, ID id) {
		UserDAOImplementer.getInstance().sync(
				new UserDAOMethodsInput(id, EffectDestinationType.REMOTE, "",
						user));
	}
}
