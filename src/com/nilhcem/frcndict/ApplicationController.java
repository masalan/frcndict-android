package com.nilhcem.frcndict;

import android.app.Application;

// must stay in the root package. see ImportDataService.getAppRootDir()
public final class ApplicationController extends Application {
	// Shared preferences
	public static final String PREFS_NAME = "SharedPrefs";
	public static final String PREFS_DB_PATH = "dbPath";

	@Override
	public void onCreate() {
		super.onCreate();
	}
}
