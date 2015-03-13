package com.sina.pars.woundcareassessment.model.providers;

import android.database.Cursor;
import android.net.Uri;

import com.sina.pars.woundcareassessment.model.data.person.User;

public interface UserDAO extends DAO {
	Cursor query(UserDAOMethodsInput userDAOMethodsInput);
	int update(UserDAOMethodsInput userDAOMethodsInput);
	int delete(UserDAOMethodsInput userDAOMethodsInput);
	Uri insert(UserDAOMethodsInput userDAOMethodsInput);
	User sync(UserDAOMethodsInput userDAOMethodsInput);
}
