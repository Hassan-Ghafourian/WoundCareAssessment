package com.sina.pars.woundcareassessment.model.data.bradenassessment;

import com.sina.pars.woundcareassessment.model.data.Data;

public class BradenAssessment extends Data {

	private final float sensoryPerceptionAssessment;
	private final float moistureAssessment;
	private final float activityAssessment;
	private final float mobilityAssessment;
	private final float nutritionAssessment;
	private final float frictionAndShearAssessment;

	public static class Builder{
		float sensoryPerceptionAssessment;
		float moistureAssessment;
		float activityAssessment;
		float mobilityAssessment;
		float nutritionAssessment;
		float frictionAndShearAssessment;
		
		public Builder setSensoryPerceptionAssessment(float sensoryPerceptionAssessment) {
			this.sensoryPerceptionAssessment = sensoryPerceptionAssessment;
			return this;
		}
		public Builder setMoistureAssessment(float moistureAssessment) {
			this.moistureAssessment = moistureAssessment;
			return this;
		}
		public Builder setActivityAssessment(float activityAssessment) {
			this.activityAssessment = activityAssessment;
			return this;
		}
		public Builder setMobilityAssessment(float mobilityAssessment) {
			this.mobilityAssessment = mobilityAssessment;
			return this;
		}
		public Builder setNutritionAssessment(float nutritionAssessment) {
			this.nutritionAssessment = nutritionAssessment;
			return this;
		}
		public Builder setFrictionAndShearAssessment(float frictionAndShearAssessment) {
			this.frictionAndShearAssessment = frictionAndShearAssessment;
			return this;
		}
		public BradenAssessment build(){
			return new BradenAssessment(this);
		}
	}

	private BradenAssessment(Builder builder) {
		super();
		this.sensoryPerceptionAssessment = builder.sensoryPerceptionAssessment;
		this.moistureAssessment = builder.moistureAssessment;
		this.activityAssessment = builder.activityAssessment;
		this.mobilityAssessment = builder.mobilityAssessment;
		this.nutritionAssessment = builder.nutritionAssessment;
		this.frictionAndShearAssessment = builder.frictionAndShearAssessment;
	}
	
}
