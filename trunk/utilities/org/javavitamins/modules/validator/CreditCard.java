package org.javavitamins.modules.validator;

import org.javavitamins.utilities.StringUtils;

public class CreditCard {
	
	final static String MASTER_CARD = "mastercard";
	final static String VISA_CARD = "visa";
	final static String DISCOVER_CARD = "discover";
	final static String AMEX_CARD = "amex";
	

	public CreditCard() {
	}

	public static String hide(String number) {
		return hide(number, "*");
	}

	public static String hide(String number, String x) {
		if (number == null)
			return number;
		int numberLen = number.length();
		if (numberLen > 4) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < numberLen - 4; i++)
				sb.append(x);

			sb.append(number.substring(numberLen - 4, numberLen));
			number = sb.toString();
		}
		return number;
	}

	public static boolean isValid(String number, String type) {
		number = StringUtils.extractDigits(number);
		if (type.equals(VISA_CARD)) {
			if (!number.startsWith("4"))
				return false;
			if (number.length() != 13 && number.length() != 16)
				return false;
		} else if (type.equals(MASTER_CARD)) {
			if (!number.startsWith("51") && !number.startsWith("52")
					&& !number.startsWith("53") && !number.startsWith("54")
					&& !number.startsWith("55"))
				return false;
			if (number.length() != 16)
				return false;
		} else if (type.equals(DISCOVER_CARD)) {
			if (!number.startsWith("6011"))
				return false;
			if (number.length() != 16)
				return false;
		} else if (type.equals(AMEX_CARD)) {
			if (!number.startsWith("34") && !number.startsWith("35")
					&& !number.startsWith("36") && !number.startsWith("37"))
				return false;
			if (number.length() != 15)
				return false;
		}
		return BasicValidator.isLUHN(number);
	}

}
