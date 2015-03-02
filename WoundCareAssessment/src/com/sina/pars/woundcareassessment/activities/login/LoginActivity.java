package com.sina.pars.woundcareassessment.activities.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.providers.UserDAOImplementer;
import com.sina.pars.woundcareassessment.model.web.client.SyncClient;
import com.sina.pars.woundcareassessment.model.web.response.ServerResponse;

import de.greenrobot.event.EventBus;

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
				new SyncClient("tt").sendRequest();
			}
		});
		loading();
	}

	private void loading() {
		new UserDAOImplementer();
	}

}
