package com.sina.pars.woundcareassessment.activities.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.constants.enums.RequestType;
import com.sina.pars.woundcareassessment.model.constants.enums.Role;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClientFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;
import com.sina.pars.woundcareassessment.model.providers.UserDAOImplementer;

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
				WebClient authenticatingClient = new WebClientFactory.Builder(
						RequestType.Authenticating, "userNameExpert")
						.password("password").build().getWebClient();
				authenticatingClient.sendRequest();
			}
		});
		loading();
	}

	private void loading() {
		new UserDAOImplementer();
	}

	@Override
	public void onStart() {
		super.onStart();
		EventBus.getDefault().register(this);
	}

	@Override
	public void onStop() {
		EventBus.getDefault().unregister(this);
		Toast.makeText(this, "unregister!", Toast.LENGTH_SHORT).show();
		super.onStop();
	}

	public void onEvent(ServerResponse response) {
		Toast.makeText(
				this,
				response.toString(),
				Toast.LENGTH_SHORT).show();
	}

}
