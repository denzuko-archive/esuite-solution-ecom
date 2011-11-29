package org.javavitamins.modules.validator;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javavitamins.defaults.IApplicationDefaults;
import org.javavitamins.utilities.BeanUtilities;

public class CommonValidator extends BeanUtilities {

	public static boolean isValidBlank(Object value) {

		// DATE Checking for NULL
		if (value instanceof Date) {
			if (value == null) {
				return false;
			}
			return true;
		}

		String strValue = (String) value;
		if (getValue(strValue).equalsIgnoreCase(BLANK)) {
			// System.out.println("Found BLANK");
			return false;
		}
		return true;
	}

	public static boolean isValidMinLength(Object value, String minimum) {
		// System.out.println("isValidMin() " +
		// GenericUtils.getValue(value).length() + " < " +
		// GenericUtils.getIntValue(minimum));
		if (getIntValue(minimum) > 0) {
			if (!isValidBlank(getValue(value))) {
				return false;
			}
		}
		// System.out.println("* "+ (getValue(value).length() <
		// getIntValue(minimum)));
		if (getValue(value).length() < getIntValue(minimum)) {
			// System.out.println("Exception - Less than Min");
			return false;
		}
		return true;
	}

	public static boolean isValidMaxLength(Object value, String maximum) {
		// System.out.println("isMaxLength() " +
		// getValue(value).length() + " > " +
		// getValue(maximum));
		// System.out.println("* " + (getValue(value).length() >
		// getIntValue(maximum)));
		if (getValue(value).length() > getIntValue(maximum)) {
			// System.out.println("Exception - More than Max");
			return false;
		}
		return true;
	}

	public static boolean isValidRange(Object value, String minimum, String maximum) {
		System.out.println("isValidRange() " + getValue(value) + " < " + getValue(minimum));
		System.out.println("isValidRange() " + getValue(value) + " > " + getValue(maximum));
		if (!isValidMinLength(value, minimum) && !isValidMaxLength(value, maximum)) {
			return false;
		}
		return true;
	}

	private static boolean isLeapYear(int y) {
		return y % 4 == 0 && (y % 400 == 0 || y % 100 != 0);
	}

	public static boolean isValidDate(int d, int m, int y) {
		if (d < 1 || m < 1 || m > 12)
			return false;
		if (m == 2) {
			if (isLeapYear(y))
				return d <= 29;
			else
				return d <= 28;
		} else if (m == 4 || m == 6 || m == 9 || m == 11)
			return d <= 30;
		else
			return d <= 31;
	}

	public static boolean isNumeric(String value) {
		char c;
		for (int i = 0; i < value.length(); i++) {
			c = value.charAt(i);
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericSpace(String value) {
		char c;
		for (int i = 0; i < value.length(); i++) {
			c = value.charAt(i);
			if (Character.isLetterOrDigit(c) || c == ' ') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericDouble(String value) {
		char c;
		for (int i = 0; i < value.length(); i++) {
			c = value.charAt(i);
			if (Character.isDigit(c) || c == '.') {
				continue;
			} else {
				return false;
			}
		}

		if (value.indexOf(".") != value.lastIndexOf(".")) {
			return false;
		}
		return true;
	}

	public static boolean isAlpha(String value) {
		char c;
		for (int i = 0; i < value.length(); i++) {
			c = value.charAt(i);
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphaNumeric(Object value) {
		char c;
		for (int i = 0; i < getValue(value).length(); i++) {
			c = getValue(value).charAt(i);
			if (!Character.isLetterOrDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidEmail(Object emailAddress) {
		// Set the email pattern string
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+"); // .+@.+\.[a-z]+
		// Match the given string with the pattern
		Matcher m = p.matcher(getValue(emailAddress));
		// System.out.println("Email Matches : " + m.matches());
		// System.out.println("Email Found : " + m.find());
		return m.matches();
	}

	public static boolean isAllowedOk(String value, String allowedVal) {
		char c;
		char ac;
		for (int i = 0; i < value.length(); i++) {
			c = value.charAt(i);

			for (int j = 0; j < allowedVal.length(); j++) {
				ac = allowedVal.charAt(j);
				System.out.println("Looking @ " + ac + " - " + c + " ? ");
				if (ac == '9') {
					if (Character.isDigit(c)) {
						break;
					}
				} else if (ac == 'A') {
					if (Character.isLetter(c)) {
						break;
					}
				} else {
					if (ac == c) {
						break;
					} else {
						continue;
					}
				}
			}
			System.out.println("Not Allowed Pattern...");
			return false;
		}
		System.out.println("All Ok");
		return true;
	}

}
