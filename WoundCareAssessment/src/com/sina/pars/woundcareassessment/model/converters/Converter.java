package com.sina.pars.woundcareassessment.model.converters;

public interface Converter<T> {
	public T convert(Class<T> type, Object value);
}
