package com.sina.pars.woundcareassessment.activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.web.response.ServerResponse;

import de.greenrobot.event.EventBus;

public class RegisterNewUserActivity extends Activity {

	TextView alreadyMember;
	Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.act_register);

		alreadyMember = (TextView) findViewById(R.id.alreadyMember);
		submit = (Button) findViewById(R.id.submit);

		alreadyMember.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(RegisterNewUserActivity.this,
						LoginActivity.class);
				RegisterNewUserActivity.this.startActivity(i);
			}
		});
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
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

	// This method will be called when a MessageEvent is posted
	public void onEvent(ServerResponse response) {
		Toast.makeText(this, String.valueOf(response.getStatus()),
				Toast.LENGTH_SHORT).show();
	}

}
