package com.sina.pars.woundcareassessment.model.providers;

import android.database.Cursor;
import android.net.Uri;

public interface UserDAO extends DAO {
	Cursor query(UserDAOMethodsInput userDAOMethodsInput);

	int update(UserDAOMethodsInput userDAOMethodsInput);

	int delete(UserDAOMethodsInput userDAOMethodsInput);

	Uri insert(UserDAOMethodsInput userDAOMethodsInput);

	/**
	 * sync only occurs through network,so this method will not return any data
	 * directly.Sync result will post to client by EventBus.
	 * 
	 * @param userDAOMethodsInput
	 */
	void sync(UserDAOMethodsInput userDAOMethodsInput);
}
