package com.sina.pars.woundcareassessment.activities.login;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.pars.woundcareassessment.R;
import com.sina.pars.woundcareassessment.model.constants.enums.RequestType;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClient;
import com.sina.pars.woundcareassessment.model.network.web.client.WebClientFactory;
import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;
import com.sina.pars.woundcareassessment.model.providers.UserDAOImplementer;

import de.greenrobot.event.EventBus;

public class LoginActivity extends Activity {

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
		
		loading();
	}
	
	/**
	 * initiate UI elements from layout and set their listeners
	 */
	private void initUIElementsAndListeners(){
		signIn = (Button) findViewById(R.id.signIn);
		scan = (Button) findViewById(R.id.scan);
		userName = (TextView) findViewById(R.id.accountName);
		password = (TextView) findViewById(R.id.accountPassword);
		
		signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				WebClient authenticatingClient = new WebClientFactory.Builder(
						RequestType.Authenticating, userName.getText().toString())
						.password(password.getText().toString()).build().getWebClient();
				authenticatingClient.sendRequest();
			}
		});
		scan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.initiateScan(LoginActivity.this, zxingLibConfig);
            }
        });
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE:
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
                        resultCode, data);
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
