package com.sina.pars.woundcareassessment.model.generators;

public interface Generator <Input, Output>{
	Output generate(Input input);
}
