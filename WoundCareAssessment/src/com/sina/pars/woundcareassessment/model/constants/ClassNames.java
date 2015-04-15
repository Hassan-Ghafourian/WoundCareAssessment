package com.sina.pars.woundcareassessment.model.constants;

import utilities.converters.Converter;

/**
 * Constants to store complete class names.Helps in deserilizing in some classes
 * in {@link Converter} which we some times need to test is an String equals to
 * the class name or not?
 * 
 */
public class ClassNames extends Constants {

	public static String PATIENT = "com.sina.pars.woundcareassessment.model.data.person.Patient";
	public static String PATIENT_PERSONAL_DATA = "com.sina.pars.woundcareassessment.model.data.personal.PatientPersonalData";
	public static String EXPERT_PERSONAL_DATA = "com.sina.pars.woundcareassessment.model.data.personal.ExpertPersonalData";
	public static String PERSONAL_FOLDER = "com.sina.pars.woundcareassessment.model.data.present.PersonalFolder";

}
