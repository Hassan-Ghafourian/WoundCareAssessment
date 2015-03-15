package com.sina.pars.woundcareassessment.model.constants.metadata;

import com.sina.pars.woundcareassessment.activities.login.LoginActivity;
import com.sina.pars.woundcareassessment.model.constants.Constants;

public class LoginActivityMetaData extends Constants {

	private LoginActivityMetaData() {
		super();
	}

	public static final Class<LoginActivity> ID_CLASS = LoginActivity.class;

	public static enum Methods {
		AUTHENTICATE, GET_SAFE_RAW_USER
	}

}
