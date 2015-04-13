package com.sina.pars.woundcareassessment.model.data.personal;

public class ExpertPersonalData extends PersonalData {

	public static class Builder {
		private final String userName;
		private final String name;
		private final String family;

		public Builder(String userName, String name, String family) {
			this.userName = userName;
			this.name = name;
			this.family = family;
		}

		public ExpertPersonalData build() {
			return new ExpertPersonalData(this);
		}
	}

	private ExpertPersonalData(Builder builder) {
		super(builder.userName, builder.name, builder.family);
	}

}
