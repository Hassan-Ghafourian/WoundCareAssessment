package com.sina.pars.woundcareassessment.model.network.web.client;

import utilities.id.ID;

import com.sina.pars.woundcareassessment.model.constants.enums.network.RequestType;
import com.sina.pars.woundcareassessment.model.data.person.User;

public class WebClientFactory {

	private final WebClient webClient;

	public static class Builder {
		// Required parameters
		private final RequestType type;
		private final ID id;

		// Optional parameters
		private String password = "";
		private User user;
		private String userName;


		
		public Builder(RequestType type, ID id) {
			this.type = type;
			this.id = id;
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
		case AUTHENTICATING:
			webClient = new AuthenticatClient(builder.userName,
					builder.password, builder.id);
			break;
		case DOWNLOADING:
			webClient = new DownloadClient(builder.userName, builder.id);
			break;
		case SYNC:
			webClient = new SyncClient(builder.user, builder.id);
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
