package com.sina.pars.woundcareassessment.model.web.client;

import enums.RequestType;

public class WebClientFactory {

	private final WebClient webClient;

	public static class Builder {
		// Required parameters
		private final RequestType type;
		private final String userName;

		// Optional parameters
		private String password = "";

		public Builder(RequestType type, String userName) {
			super();
			this.type = type;
			this.userName = userName;
		}

		public Builder password(String password) {
			this.password = password;
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
			webClient = new SyncClient(builder.userName);
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
