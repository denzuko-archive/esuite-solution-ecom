package org.javavitamins.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class GetterUtils {

	public static final boolean DEFAULT_BOOLEAN = false;
	public static final double DEFAULT_DOUBLE = 0D;
	public static final float DEFAULT_FLOAT = 0F;
	public static final int DEFAULT_INTEGER = 0;
	public static final long DEFAULT_LONG = 0L;
	public static final short DEFAULT_SHORT = 0;
	public static final String DEFAULT_STRING = "";
	public static String BOOLEANS[] = {"true", "t", "y", "on", "1"};

	public GetterUtils() {
	}

	public static boolean getBoolean(String value) {
		return getBoolean(value, false);
	}

	public static boolean getBoolean(String value, boolean defaultValue) {
		return get(value, defaultValue);
	}

	public static Date getDate(String value, DateFormat df) {
		return getDate(value, df, new Date());
	}

	public static Date getDate(String value, DateFormat df, Date defaultValue) {
		return get(value, df, defaultValue);
	}

	public static double getDouble(String value) {
		return getDouble(value, 0.0D);
	}

	public static double getDouble(String value, double defaultValue) {
		return get(value, defaultValue);
	}

	public static float getFloat(String value) {
		return getFloat(value, 0.0F);
	}

	public static float getFloat(String value, float defaultValue) {
		return get(value, defaultValue);
	}

	public static int getInteger(String value) {
		return getInteger(value, 0);
	}

	public static int getInteger(String value, int defaultValue) {
		return get(value, defaultValue);
	}

	public static long getLong(String value) {
		return getLong(value, 0L);
	}

	public static long getLong(String value, long defaultValue) {
		return get(value, defaultValue);
	}

	public static short getShort(String value) {
		return getShort(value, (short) 0);
	}

	public static short getShort(String value, short defaultValue) {
		return get(value, defaultValue);
	}

	public static String getString(String value) {
		return getString(value, "");
	}

	public static String getString(String value, String defaultValue) {
		return get(value, defaultValue);
	}

	public static boolean get(String value, boolean defaultValue) {
		if (value == null)
			return false;
		value = value.trim();
		if (value.equalsIgnoreCase(BOOLEANS[0])
				|| value.equalsIgnoreCase(BOOLEANS[1])
				|| value.equalsIgnoreCase(BOOLEANS[2])
				|| value.equalsIgnoreCase(BOOLEANS[3])
				|| value.equalsIgnoreCase(BOOLEANS[4]))
			return true;
		return false;
	}

	public static Date get(String value, DateFormat df, Date defaultValue) {
		Date date = null;
		try {
			date = df.parse(value.trim());
			if (date != null)
				return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	public static double get(String value, double defaultValue) {
		try {
			return Double.parseDouble(_trim(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	public static float get(String value, float defaultValue) {
		try {
			return Float.parseFloat(_trim(value));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return defaultValue;
	}

	public static int get(String value, int defaultValue) {
		try {
			return Integer.parseInt(_trim(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	public static long get(String value, long defaultValue) {
		try {
			return Long.parseLong(_trim(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	public static short get(String value, short defaultValue) {
		try {
			return Short.parseShort(_trim(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	public static String get(String value, String defaultValue) {
		if (value != null) {
			value = value.trim();
			value = StringUtils.replace(value, "\r\n", "\n");
			return value;
		} else {
			return defaultValue;
		}
	}

	private static final String _trim(String value) {
		if (value != null) {
			value = value.trim();
			StringBuffer sb = new StringBuffer();
			char charArray[] = value.toCharArray();
			for (int i = 0; i < charArray.length; i++)
				if (Character.isDigit(charArray[i]) || charArray[i] == '-'
						&& i == 0 || charArray[i] == '.')
					sb.append(charArray[i]);

			value = sb.toString();
		}
		return value;
	}

}
