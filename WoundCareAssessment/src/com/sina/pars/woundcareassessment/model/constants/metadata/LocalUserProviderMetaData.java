package com.sina.pars.woundcareassessment.model.constants.metadata;

import com.sina.pars.woundcareassessment.model.constants.Constants;

import android.net.Uri;

public class LocalUserProviderMetaData extends Constants {
	public static final String SCHEME = "content://";
	public static final String AUTHORITY = "com.sina.pars.woundcareassessment.model.providers.LocalUserProvider";

	private LocalUserProviderMetaData() {
		super();
	}

	public static final class LocalUserTableMetaData {

		private LocalUserTableMetaData() {
		}

		public static final String TABLE_NAME = "local-user";
		public static final String PATH = "/" + TABLE_NAME;

		// uri and MIME type definitions:
		public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY
				+ PATH);
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd."
				+ AUTHORITY + "." + TABLE_NAME;
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."
				+ AUTHORITY + "." + TABLE_NAME;
	}
}
