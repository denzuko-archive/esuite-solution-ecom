package org.javavitamins.modules.validator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.javavitamins.defaults.IApplicationDefaults;
import org.javavitamins.utilities.BeanUtilities;
import org.javavitamins.utilities.CollectionUtils;
import org.javavitamins.utilities.GenericUtils;

public class Validator extends BeanUtilities implements IApplicationDefaults, IValidator {

	public static int match(String key, String value) {
		int chkValue = NONE;
		if (key.equalsIgnoreCase("required")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = REQUIRED;
			}
		}
		if (key.equalsIgnoreCase("minimum")) {
			chkValue = MINIMUM;
		}
		if (key.equalsIgnoreCase("maximum")) {
			chkValue = MAXIMUM;
		}
		if (key.equalsIgnoreCase("date")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = DATE;
			}
		}
		if (key.equalsIgnoreCase("email")) {
			if (value.equalsIgnoreCase("true")) {
//				chkValue = EMAIL; TODO *************************
			}
		}
		if (key.equalsIgnoreCase("numeric")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = NUMERIC;
			}
		}
		if (key.equalsIgnoreCase("alpha")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = ALPHA;
			}
		}
		if (key.equalsIgnoreCase("alphanumeric")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = ALPHA_NUMERIC;
			}
		}
		if (key.equalsIgnoreCase("numericdouble")) {
			if (value.equalsIgnoreCase("true")) {
				chkValue = NUMERIC_DOUBLE;
			}
		}
		if (key.equalsIgnoreCase("format")) {
			chkValue = FORMAT;
		}
		if (key.equalsIgnoreCase("pattern")) {
			chkValue = PATTERN;
		}
		if (key.equalsIgnoreCase("allowed")) {
			chkValue = ALLOWED;
		}
		return chkValue;
	}

	public static boolean validate(String style, String value) {
		System.out.println("Inside validate");
		
		boolean validationStatus = true; // Outcome for All Validations
		
		boolean blankValidationStatus = true;
		boolean minValidationStatus = true;
		boolean maxValidationStatus = true;
		boolean emailValidationStatus = true;
		boolean dateValidationStatus = true;
		boolean numericValidationStatus = true;
		boolean alphaValidationStatus = true;
		boolean alphaNumericValidationStatus = true;
		boolean numericDoubleValidationStatus = true;

		boolean formatValidationStatus = true;
		boolean patternValidationStatus = true;
		boolean allowedValidationStatus = true;

		Map styleMap = CollectionUtils.convertStringToMap(getValue(style));
		Collection styleKeys = styleMap.keySet();
		Iterator styleItr = styleKeys.iterator();
		while (styleItr.hasNext()) {
			String key = getValue(styleItr.next());
			String keyValue = getValue(styleMap.get(getValue(key)));
			int chkValue = match(getValue(key), getValue(keyValue));
			// System.out.println(chkValue);
			switch (getIntValue(chkValue)) {
			case REQUIRED:
				blankValidationStatus = CommonValidator.isValidBlank(value);
				break;
			case MINIMUM:
				blankValidationStatus = CommonValidator.isValidBlank(value);
				if (blankValidationStatus)
					minValidationStatus = CommonValidator.isValidMinLength(value, getValue(keyValue));
				break;
			case MAXIMUM:
				maxValidationStatus = CommonValidator.isValidMaxLength(value, getValue(keyValue));
				break;
			/*
			case EMAIL:
				if (!getValue(value).equalsIgnoreCase(BLANK)) {
					emailValidationStatus = CommonValidator.isValidEmail(value);
				}
				break;
			*/
			case DATE:
				System.out.println("Date Validation ... ***");
				break;
			case NUMERIC:
				System.out.println("NUMERIC Validation ... Processing");
				numericValidationStatus = CommonValidator.isNumeric(getValue(value));
				break;
			case ALPHA:
				System.out.println("ALPHA Validation ... Processing");
				alphaValidationStatus = CommonValidator.isAlpha(getValue(value));
				break;
			case ALPHA_NUMERIC:
				System.out.println("ALPHANUMERIC Validation ... Processing");
				alphaNumericValidationStatus = CommonValidator.isAlphaNumeric(getValue(value));
				break;
			case NUMERIC_DOUBLE:
				System.out.println("DOUBLE NUMERIC Validation ... Processing");
				numericDoubleValidationStatus = CommonValidator.isNumericDouble(getValue(value));
				break;
			case FORMAT:
				System.out.println("FORMAT Validation - TODO");
				break;

			case PATTERN:
				System.out.println("Patern Validation - TODO");
				break;

			case ALLOWED:
				String allowedValue = getValue(styleMap.get(getValue(IValidatorKey.ALLOWED)));
				System.out.println("Allowed - " + allowedValue);
				allowedValidationStatus = CommonValidator.isAllowedOk(value, allowedValue);
				System.out.println("allowedValidationStatus - " + allowedValidationStatus);
				break;
			}

//			System.out.println("blankValidationStatus - " + blankValidationStatus);
//			System.out.println("minValidationStatus - " + minValidationStatus);
//			System.out.println("maxValidationStatus - " + maxValidationStatus);
//			System.out.println("emailValidationStatus - " + emailValidationStatus);
//			System.out.println("dateValidationStatus - " + dateValidationStatus);
//			System.out.println("numericValidationStatus " + numericValidationStatus);
//			System.out.println("alphaValidationStatus - " + alphaValidationStatus);
//			System.out.println("alphaNumericValidationStatus - " + alphaNumericValidationStatus);
//			System.out.println("numericDoubleValidationStatus - " + numericDoubleValidationStatus);
//			System.out.println("formatValidationStatus - " + formatValidationStatus);
//			System.out.println("patternValidationStatus - " + patternValidationStatus);
			System.out.println("allowedValidationStatus; - " + allowedValidationStatus);
			
			validationStatus = blankValidationStatus && minValidationStatus && maxValidationStatus && emailValidationStatus && dateValidationStatus && numericValidationStatus && alphaValidationStatus && alphaNumericValidationStatus && numericDoubleValidationStatus && formatValidationStatus && patternValidationStatus && allowedValidationStatus;
			
			System.out.println("validationStatus - " + validationStatus);
			if (!validationStatus) {
				break;
			}
		}
		
		return validationStatus;
	}

	public static void main(String[] args) {
		// minimum:2;maximum:7;email:true;required:true;
		// allowed:A9#;
//		System.out.println(Validator.validate("allowed:A9.@#$(&);", "2)"));
		System.out.println(Validator.validate("minimum:2;", "345"));
	}

}
