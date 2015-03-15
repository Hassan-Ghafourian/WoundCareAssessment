package utilities.dialog;

import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;

public interface Alertable {
	void onAlert(ServerResponse response, TryAgainResult tryAgainResult);
}
