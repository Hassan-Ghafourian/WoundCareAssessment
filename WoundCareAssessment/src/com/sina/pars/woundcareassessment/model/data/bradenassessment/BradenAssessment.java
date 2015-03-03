package com.sina.pars.woundcareassessment.model.data.bradenassessment;

import com.sina.pars.woundcareassessment.model.data.Data;

public class BradenAssessment extends Data{

	private final float SensoryPerceptionAssessment;
	private final float MoistureAssessment;
	private final float ActivityAssessment;
	private final float MobilityAssessment;
	private final float NutritionAssessment;
	private final float FrictionAndShearAssessment;

	public BradenAssessment(float sensoryPerceptionAssessment,
			float moistureAssessment, float activityAssessment,
			float mobilityAssessment, float nutritionAssessment,
			float frictionAndShearAssessment) {
		super();
		SensoryPerceptionAssessment = sensoryPerceptionAssessment;
		MoistureAssessment = moistureAssessment;
		ActivityAssessment = activityAssessment;
		MobilityAssessment = mobilityAssessment;
		NutritionAssessment = nutritionAssessment;
		FrictionAndShearAssessment = frictionAndShearAssessment;
	}

}
