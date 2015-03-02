package com.sina.pars.woundcareassessment.model.providers;

import android.database.Cursor;
import android.net.Uri;

public interface DAO {

	public int delete();
	
	public Uri insert();

	public Cursor query();

	public int update(); 
	
}
