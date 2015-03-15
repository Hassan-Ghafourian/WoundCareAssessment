package com.sina.pars.woundcareassessment.activities.login;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import utilities.dialog.Alertable;
import utilities.dialog.TryAgainResult;
import utilities.dialog.WebCilentTryAgainDialog;
import utilities.id.ID;
import utilities.id.IdentifiedObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.constants.enums.data.Role;
import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestType;
import com.sina.pars.woundcareassessment.model.constants.enums.network.ServerResponseType;
import com.sina.pars.woundcareassessment.model.constants.metadata.LoginActivityMetaData;
import com.sina.pars.woundcareassessment.model.data.person.Newcomer;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClientFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;
import com.sina.pars.woundcareassessment.model.providers.SafeRawUser;

import de.greenrobot.event.EventBus;

public class LoginActivity extends Activity implements Alertable,
		IdentifiedObject<ID> {

	Button signIn;
	Button scan;
	TextView userName;
	TextView password;
	private ZXingLibConfig zxingLibConfig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.act_login);

		initUIElementsAndListeners();
	}

	/**
	 * initiate UI elements from layout and set their listeners
	 */
	private void initUIElementsAndListeners() {
		signIn = (Button) findViewById(R.id.signIn);
		scan = (Button) findViewById(R.id.scan);
		userName = (TextView) findViewById(R.id.accountName);
		password = (TextView) findViewById(R.id.accountPassword);

		signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				authenticate();
			}
		});
		scan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				IntentIntegrator.initiateScan(LoginActivity.this,
						zxingLibConfig);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case IntentIntegrator.REQUEST_CODE:
			IntentResult scanResult = IntentIntegrator.parseActivityResult(
					requestCode, resultCode, data);
			if (scanResult == null) {
				return;
			}
			final String result = scanResult.getContents();
			if (result != null) {
				userName.setText(result);
			}
			break;
		default:
		}
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

	private void authenticate() {
		WebClient authenticatingClient = new WebClientFactory.Builder(
				RequestType.Authenticating,
				getId(LoginActivityMetaData.Methods.AUTHENTICATE))
				.userName(userName.getText().toString())
				.password(password.getText().toString()).build().getWebClient();
		authenticatingClient.sendRequest();
	}

	private void getSafeRawUser() {
		SafeRawUser.getSafe(userName.getText().toString(),
				getId(LoginActivityMetaData.Methods.GET_SAFE_RAW_USER));
	}

	public void onEvent(ServerResponse response) {
		if (this.matchID(response.getId())) {
			if (response.getType() == ServerResponseType.AuthenticatingResponse) {
				switch (response.getStatus()) {
				case OK:
					Newcomer newcomer = new Newcomer((Role) response.getBody(),
							userName.getText().toString());
					getSafeRawUser();
					break;
				default:
					WebCilentTryAgainDialog.setListenersAndShow(this, response);
					break;
				}
			}
			// TODO Add other situations ...
		}
	}

	@Override
	public void onAlert(ServerResponse response, TryAgainResult tryAgainResult) {
		if (tryAgainResult == TryAgainResult.YES) {
			matchSwitch(response.getId());
		}
	}

	@Override
	public ID getId(Object idSwitch) {
		return new ID(this.getClass(), idSwitch);
	}

	@Override
	public void matchSwitch(ID id) {
		switch ((LoginActivityMetaData.Methods) id.getIdSwitch()) {
		case AUTHENTICATE:
			authenticate();
			break;
		case GET_SAFE_RAW_USER:
			getSafeRawUser();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean matchID(ID id) {
		if (LoginActivityMetaData.ID_CLASS.equals(id.getIdClass())) {
			return true;
		}
		return false;
	}

}
