package com.sina.pars.woundcareassessment.model.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import stringcrud.Row;
import stringcrud.StringCRUD;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

import com.sina.pars.woundcareassessment.model.constants.metadata.LocalUserProviderMetaData;

public class LocalUserProvider extends ContentProvider {

	private static final int INCOMING_LOCAL_SINGLE_USER_URI_INDICATOR = 1;
	private static UriMatcher uriMatcher;
	private Context context;
	private static final String LOCAL_DATA_FILE_NAME = "local data file";
	private String tree;

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(LocalUserProviderMetaData.AUTHORITY,
				LocalUserProviderMetaData.LocalUserTableMetaData.TABLE_NAME
						+ "/*", INCOMING_LOCAL_SINGLE_USER_URI_INDICATOR);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		return 0;
	}

	@Override
	public String getType(Uri uri) {

		switch (uriMatcher.match(uri)) {
		case INCOMING_LOCAL_SINGLE_USER_URI_INDICATOR:
			return LocalUserProviderMetaData.LocalUserTableMetaData.CONTENT_ITEM_TYPE;
		default:
			throw new IllegalArgumentException("the URI >> " + uri.toString()
					+ "does not match");
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {

		return null;
	}

	@Override
	public boolean onCreate() {
		Log.d("Tag", "UserProvider.onCreate()");
		this.context = getContext();
		File file = context.getFileStreamPath(LOCAL_DATA_FILE_NAME);
		if (file.exists()) {
			tree = readFile(LOCAL_DATA_FILE_NAME);
			if (tree == null) {
				return false;
			}
		} else {
			WriteFile(LOCAL_DATA_FILE_NAME, "In the name of God");
			tree = "";
		}
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		switch (uriMatcher.match(uri)) {
		case INCOMING_LOCAL_SINGLE_USER_URI_INDICATOR:
			String userName = uri.getPathSegments().get(1);
			Row row = StringCRUD.query(tree, userName);
			MatrixCursor cursor;
			cursor = new MatrixCursor(new String[] { "column1" });
			if (!"".equals(row.getID())) {//userName exists and was found
				cursor.newRow().add(row);
			}
			return cursor;
		default:
			throw new IllegalArgumentException("the URI >> [" + uri.toString()
					+ "] does not match");
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {

		return 0;
	}

	private String readFile(String fileName) {
		// Read text from file
		FileInputStream fis = null;
		try {
			fis = context.openFileInput(fileName);
			byte[] reader = new byte[fis.available()];
			while (fis.read(reader) != -1) {
			}
			return new String(reader);
		} catch (IOException e) {
			return null;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}

		}

	}

	/**
	 * Creates the file if it doesn't already exist and write text.Else override
	 * file context,does not append.
	 * 
	 * @param fileName
	 * @param text
	 * @return
	 */
	private boolean WriteFile(String fileName, String text) {
		FileOutputStream fos = null;
		try {
			fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			fos.write(text.getBytes());
		} catch (Exception e) {
			return false;
		} finally {
			if (fos != null) {
				try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		return true;
	}
}
