package com.sina.pars.woundcareassessment.activities.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClientFactory;
import com.sina.pars.woundcareassessment.model.providers.UserDAOImplementer;

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
				WebClient authenticatingClient = new WebClientFactory.Builder(
						RequestType.Authenticating, "userName").password("password").build().getWebClient();
				authenticatingClient.sendRequest();
			}
		});
		loading();
	}

	private void loading() {
		new UserDAOImplementer();
	}

}
