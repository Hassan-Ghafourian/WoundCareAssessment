package com.sina.pars.woundcareassessment.model.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class UserProvider extends ContentProvider {

	private Context context;

	private static final String LOCAL_DATA_FILE_NAME = "test";
	private String tree;

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		return 0;
	}

	@Override
	public String getType(Uri uri) {

		return null;
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
			// file.createNewFile();
			WriteFile(LOCAL_DATA_FILE_NAME, "In the name of God");
			tree = "";
		}
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		return null;
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
					// swallow
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
					// swallow
				}
			}
		}
		return true;
	}
}
