package com.sina.pars.woundcareassessment.model.network.connection;

import java.io.IOException;

public class Internetconnection {
	public static boolean isDeviceOnline() {

		Runtime runtime = Runtime.getRuntime();
		try {

			Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
			int exitValue = ipProcess.waitFor();
			return (exitValue == 0);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return false;
	}
}
