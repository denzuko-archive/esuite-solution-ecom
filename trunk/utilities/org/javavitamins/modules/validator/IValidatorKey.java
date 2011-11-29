package org.javavitamins.modules.validator;

public interface IValidatorKey {

	final String NONE = "";
	final String REQUIRED = "required";
	final String MINIMUM = "minimum";
	final String MAXIMUM = "maximum";
	final String DATE = "date";
	final String EMAIL = "email";
	final String NUMERIC = "numeric";
	final String ALPHA = "alpha";
	final String ALPHA_NUMERIC = "alphanumeric";
	final String NUMERIC_DOUBLE = "numericdouble";

	final String FORMAT = "format";
	final String PATTERN = "pattern";
	final String ALLOWED = "allowed";
	
}
