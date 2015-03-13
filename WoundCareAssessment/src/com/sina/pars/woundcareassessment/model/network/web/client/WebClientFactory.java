package com.sina.pars.woundcareassessment.model.network.web.client;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestType;
import com.sina.pars.woundcareassessment.model.data.person.User;

public class WebClientFactory {

	private final WebClient webClient;

	public static class Builder {
		// Required parameters
		private final RequestType type;

		// Optional parameters
		private String password = "";
		private User user;
		private String userName;

		public Builder(RequestType type) {
			this.type = type;
		}

		
		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}


		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder user(User user) {
			this.user = user;
			return this;
		}

		public WebClientFactory build() {
			return new WebClientFactory(this);
		}
	}

	private WebClientFactory(Builder builder) {
		switch (builder.type) {
		case Authenticating:
			webClient = new AuthenticatClient(builder.userName,
					builder.password);
			break;
		case Downloading:
			webClient = new DownloadClient(builder.userName);
			break;
		case Sync:
			webClient = new SyncClient(builder.user);
			break;

		default:
			webClient = null;
			break;
		}
	}

	public WebClient getWebClient() {
		return webClient;
	}

}
