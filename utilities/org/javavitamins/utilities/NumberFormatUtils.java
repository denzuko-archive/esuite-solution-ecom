package org.javavitamins.utilities;

import java.text.NumberFormat;

public class NumberFormatUtils {

	public NumberFormatUtils() {
	}

	public static final String format(NumberFormat nf, double number,
			double defaultValue) {
		if (Double.isNaN(number) || Double.isInfinite(number))
			return nf.format(defaultValue);
		else
			return nf.format(number);
	}

	public static final String format(NumberFormat nf, float number,
			float defaultValue) {
		if (Float.isNaN(number) || Float.isInfinite(number))
			return nf.format(defaultValue);
		else
			return nf.format(number);
	}

}
