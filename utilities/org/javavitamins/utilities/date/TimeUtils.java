package org.javavitamins.utilities.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtils {
	
	public static final long SECOND = 1000L;
	public static final long MINUTE = 60000L;
	public static final long HOUR = 0x36ee80L;
	public static final long DAY = 0x5265c00L;
	public static final long WEEK = 0x240c8400L;
	public static final String RFC822_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";
	public static final String TIMESTAMP_FORMAT = "yyyyMMddkkmmssSSS";
	public static final String SHORT_TIMESTAMP_FORMAT = "yyyyMMddkkmm";
	
	public TimeUtils() {
	}
	
	public static Date getDate(Calendar cal) {
		Calendar adjustedCal = new GregorianCalendar();
		adjustedCal.set(1, cal.get(1));
		adjustedCal.set(2, cal.get(2));
		adjustedCal.set(5, cal.get(5));
		adjustedCal.set(11, cal.get(11));
		adjustedCal.set(12, cal.get(12));
		adjustedCal.set(13, cal.get(13));
		adjustedCal.set(14, cal.get(14));
		return adjustedCal.getTime();
	}

	public static Date getDate(TimeZone tz) {
		Calendar cal = new GregorianCalendar(tz);
		return getDate(cal);
	}

	public static Date getDate(Date date, TimeZone tz) {
		Calendar cal = new GregorianCalendar(tz);
		cal.setTime(date);
		return getDate(cal);
	}

	public static String getDescription(long milliseconds) {
		String s = "";
		int x = 0;
		if (milliseconds % 0x240c8400L == 0L) {
			x = (int) (milliseconds / 0x240c8400L);
			s = x + " Week";
		} else if (milliseconds % 0x5265c00L == 0L) {
			x = (int) (milliseconds / 0x5265c00L);
			s = x + " Day";
		} else if (milliseconds % 0x36ee80L == 0L) {
			x = (int) (milliseconds / 0x36ee80L);
			s = x + " Hour";
		} else if (milliseconds % 60000L == 0L) {
			x = (int) (milliseconds / 60000L);
			s = x + " Minute";
		} else if (milliseconds % 1000L == 0L) {
			x = (int) (milliseconds / 1000L);
			s = x + " Second";
		}
		if (x > 1)
			s += (new StringBuffer()).append('s').toString();
		return s;
	}

	public static String getRFC822() {
		return getRFC822(new Date());
	}

	public static String getRFC822(Date date) {
		return getSimpleDate(date, "EEE, dd MMM yyyy HH:mm:ss Z");
	}

	public static String getShortTimestamp() {
		return getShortTimestamp(new Date());
	}

	public static String getShortTimestamp(Date date) {
		return getSimpleDate(date, "yyyyMMddkkmm");
	}

	public static String getSimpleDate(Date date, String format) {
		String s = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			s = sdf.format(date);
		}
		return s;
	}

	public static String getTimestamp() {
		return getTimestamp(new Date());
	}

	public static String getTimestamp(Date date) {
		return getSimpleDate(date, "yyyyMMddkkmmssSSS");
	}

}
