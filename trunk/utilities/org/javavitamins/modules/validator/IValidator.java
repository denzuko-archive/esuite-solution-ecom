package org.javavitamins.modules.validator;

public interface IValidator {

	public static final int NONE = 0;
	public static final int REQUIRED = 1;
	public static final int MINIMUM = 2;
	public static final int MAXIMUM = 3;
	public static final int DATE = 4;
	public static final int EMAIL = 5;
	public static final int NUMERIC = 6;
	public static final int ALPHA = 7;
	public static final int ALPHA_NUMERIC = 8;
	public static final int NUMERIC_DOUBLE = 9;
	
	final int FORMAT = 10;
	final int PATTERN = 11;
	final int ALLOWED = 12;
	
	final int SINGULAR = 13;

}
