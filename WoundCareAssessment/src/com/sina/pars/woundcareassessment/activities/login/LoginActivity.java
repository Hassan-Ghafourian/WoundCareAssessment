package com.sina.pars.woundcareassessment.activities.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.providers.UserDAOImplementer;
import com.sina.pars.woundcareassessment.model.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.web.client.WebClientBuilder;

import enums.RequestType;

public class LoginActivity extends Activity {

	Button signIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.act_login);
		signIn = (Button) findViewById(R.id.signIn);
		signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				WebClient authenticatingClient = new WebClientBuilder.Builder(
						RequestType.Authenticating, "userName").password("password").build().getWebClient();
				authenticatingClient.sendRequest();
				WebClient syncClient = new WebClientBuilder.Builder(
						RequestType.Sync, "userName").build().getWebClient();
				syncClient.sendRequest();
			}
		});
		loading();
	}

	private void loading() {
		new UserDAOImplementer();
	}

}
