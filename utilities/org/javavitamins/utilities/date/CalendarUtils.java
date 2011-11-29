package org.javavitamins.utilities.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.javavitamins.modules.validator.BasicValidator;

public class CalendarUtils {
	
	public static String DAYS_ABBREVIATION[] = {
        "sunday-abbreviation", "monday-abbreviation", "tuesday-abbreviation", "wednesday-abbreviation", "thursday-abbreviation", "friday-abbreviation", "saturday-abbreviation"
    };
    public static int MONTH_IDS[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11
    };
    
    public CalendarUtils()
    {
    }
    
    public static boolean afterByDay(Date date1, Date date2)
    {
        long millis1 = date1.getTime() / 0x5265c00L;
        long millis2 = date2.getTime() / 0x5265c00L;
        return millis1 > millis2;
    }

    public static boolean beforeByDay(Date date1, Date date2)
    {
        long millis1 = date1.getTime() / 0x5265c00L;
        long millis2 = date2.getTime() / 0x5265c00L;
        return millis1 < millis2;
    }

    public static boolean equalsByDay(Date date1, Date date2)
    {
        long millis1 = date1.getTime() / 0x5265c00L;
        long millis2 = date2.getTime() / 0x5265c00L;
        return millis1 == millis2;
    }

    public static int getAge(Date date, TimeZone tz)
    {
        return getAge(date, ((Calendar) (new GregorianCalendar(tz))));
    }

    public static int getAge(Date date, Calendar today)
    {
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(date);
        int yearDiff = today.get(1) - birthday.get(1);
        if(today.get(2) < birthday.get(2))
            yearDiff--;
        else
        if(today.get(2) == birthday.get(2) && today.get(5) < birthday.get(5))
            yearDiff--;
        return yearDiff;
    }

    /* TODO
     * public static String[] getDays(Locale locale)
    {
        return getDays(locale, null);
    } */

    /* TODO
    public static String[] getDays(Locale locale, String pattern)
    {
        if(Validator.isNull(pattern))
            pattern = "EEEE";
        StringBuffer sb = new StringBuffer();
        sb.append("util-java.days_");
        sb.append(pattern);
        sb.append("_");
        sb.append(locale.getLanguage());
        sb.append("_");
        sb.append(locale.getCountry());
        String id = sb.toString();
        String days[] = (String[])SimpleCachePool.get(id);
        if(days == null)
        {
            days = new String[7];
            DateFormat dayFormat = new SimpleDateFormat(pattern, locale);
            Calendar cal = new GregorianCalendar();
            cal.set(5, 1);
            for(int i = 0; i < 7; i++)
            {
                cal.set(7, i + 1);
                days[i] = dayFormat.format(cal.getTime());
            }

            SimpleCachePool.put(id, days);
        }
        return days;
    } */

    public static int getDaysInMonth(Calendar cal)
    {
        return getDaysInMonth(cal.get(2), cal.get(1));
    }

    public static int getDaysInMonth(int month, int year)
    {
        if(++month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if(month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return (year % 4 != 0 || year % 100 == 0) && year % 400 != 0 ? 28 : 29;
    }

    public static int getGregorianDay(Calendar cal)
    {
        int year = cal.get(1) - 1600;
        int month = cal.get(2) + 1;
        if(month < 3)
            month += 12;
        int day = cal.get(5);
        int gregorianDay = (int)(((6286D + (double)year * 365.25D) - (double)(year / 100)) + (double)(year / 400) + 30.600000000000001D * (double)month + 0.20000000000000001D + (double)day);
        return gregorianDay;
    }

    public static Date getGTDate(Calendar cal)
    {
        Calendar gtCal = (Calendar)cal.clone();
        gtCal.set(11, 0);
        gtCal.set(12, 0);
        gtCal.set(13, 0);
        gtCal.set(14, 0);
        return gtCal.getTime();
    }

    public static int getLastDayOfWeek(Calendar cal)
    {
        int firstDayOfWeek = cal.getFirstDayOfWeek();
        if(firstDayOfWeek == 1)
            return 7;
        if(firstDayOfWeek == 2)
            return 1;
        if(firstDayOfWeek == 3)
            return 2;
        if(firstDayOfWeek == 4)
            return 3;
        if(firstDayOfWeek == 5)
            return 4;
        return firstDayOfWeek != 6 ? 6 : 5;
    }

    public static Date getLTDate(Calendar cal)
    {
        Calendar ltCal = (Calendar)cal.clone();
        ltCal.set(11, 23);
        ltCal.set(12, 59);
        ltCal.set(13, 59);
        ltCal.set(14, 999);
        return ltCal.getTime();
    }

    public static int[] getMonthIds()
    {
        return MONTH_IDS;
    }

    /* TODO public static String[] getMonths(Locale locale)
    {
        return getMonths(locale, null);
    } */

   /* TODO public static String[] getMonths(Locale locale, String pattern)
    {
        if(Validator.isNull(pattern))
            pattern = "MMMM";
        StringBuffer sb = new StringBuffer();
        sb.append("util-java.months_");
        sb.append(pattern);
        sb.append("_");
        sb.append(locale.getLanguage());
        sb.append("_");
        sb.append(locale.getCountry());
        String id = sb.toString();
        String months[] = (String[])SimpleCachePool.get(id);
        if(months == null)
        {
            months = new String[12];
            DateFormat monthFormat = new SimpleDateFormat(pattern, locale);
            Calendar cal = new GregorianCalendar();
            cal.set(5, 1);
            for(int i = 0; i < 12; i++)
            {
                cal.set(2, i);
                months[i] = monthFormat.format(cal.getTime());
            }

            SimpleCachePool.put(id, months);
        }
        return months;
    } */

    public static Timestamp getTimestamp(Date date)
    {
        if(date == null)
            return null;
        else
            return new Timestamp(date.getTime());
    }

    public static boolean isAfter(int month1, int day1, int year1, int hour1, int minute1, int amPm1, int month2, int day2, 
            int year2, int hour2, int minute2, int amPm2, TimeZone timeZone, Locale locale)
    {
        Calendar cal1 = new GregorianCalendar(timeZone, locale);
        cal1.set(2, month1);
        cal1.set(5, day1);
        cal1.set(1, year1);
        cal1.set(10, hour1);
        cal1.set(12, minute1);
        cal1.set(9, amPm1);
        Calendar cal2 = new GregorianCalendar(timeZone, locale);
        cal2.set(2, month2);
        cal2.set(5, day2);
        cal2.set(1, year2);
        cal2.set(10, hour2);
        cal2.set(12, minute2);
        cal2.set(9, amPm2);
        return cal1.after(cal2);
    }

    public static boolean isBroadcastDate(int month, int day, int year)
    {
        if(!isDate(month, day, year))
            return false;
        Calendar cal1 = new GregorianCalendar();
        cal1.setFirstDayOfWeek(2);
        cal1.set(2, month);
        cal1.set(5, day);
        cal1.set(1, year);
        Calendar cal2 = new GregorianCalendar();
        cal2.setFirstDayOfWeek(2);
        cal2.set(2, month + 1);
        cal2.set(5, 1);
        cal2.set(1, year);
        return cal2.get(7) == 2 || cal2.get(3) != cal1.get(3);
    }

    public static boolean isDate(int month, int day, int year)
    {
        return isGregorianDate(month, day, year);
    }

    public static boolean isFuture(int month, int year)
    {
        return isFuture(month, year, TimeZone.getDefault(), Locale.getDefault());
    }

    public static boolean isFuture(int month, int year, TimeZone timeZone, Locale locale)
    {
        Calendar curCal = new GregorianCalendar(timeZone, locale);
        curCal.set(5, 1);
        Calendar cal = (Calendar)curCal.clone();
        cal.set(2, month);
        cal.set(1, year);
        return cal.after(curCal);
    }

    public static boolean isFuture(int month, int day, int year)
    {
        return isFuture(month, day, year, TimeZone.getDefault(), Locale.getDefault());
    }

    public static boolean isFuture(int month, int day, int year, TimeZone timeZone, Locale locale)
    {
        Calendar curCal = new GregorianCalendar(timeZone, locale);
        Calendar cal = (Calendar)curCal.clone();
        cal.set(2, month);
        cal.set(5, day);
        cal.set(1, year);
        return cal.after(curCal);
    }

    public static boolean isFuture(int month, int day, int year, int hour, int minute, int amPm)
    {
        return isFuture(month, day, year, hour, minute, amPm, TimeZone.getDefault(), Locale.getDefault());
    }

    public static boolean isFuture(int month, int day, int year, int hour, int minute, int amPm, TimeZone timeZone, Locale locale)
    {
        Calendar curCal = new GregorianCalendar(timeZone, locale);
        Calendar cal = (Calendar)curCal.clone();
        cal.set(2, month);
        cal.set(5, day);
        cal.set(1, year);
        cal.set(10, hour);
        cal.set(12, minute);
        cal.set(9, amPm);
        return cal.after(curCal);
    }

    public static boolean isGregorianDate(int month, int day, int year)
    {
        if(month < 0 || month > 11)
            return false;
        int months[] = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 
            30, 31
        };
        if(month == 1)
        {
            int febMax = 28;
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                febMax = 29;
            if(day < 0 || day > febMax)
                return false;
        } else
        if(day < 0 || day > months[month])
            return false;
        return true;
    }

    public static boolean isJulianDate(int month, int day, int year)
    {
        if(month < 0 || month > 11)
            return false;
        int months[] = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 
            30, 31
        };
        if(month == 1)
        {
            int febMax = 28;
            if(year % 4 == 0)
                febMax = 29;
            if(day < 0 || day > febMax)
                return false;
        } else
        if(day < 0 || day > months[month])
            return false;
        return true;
    }

    public static Calendar roundByMinutes(Calendar cal, int interval)
    {
        int minutes = cal.get(12);
        int delta = 0;
        if(minutes < interval)
            delta = interval - minutes;
        else
            delta = interval - minutes % interval;
        if(delta == interval)
            delta = 0;
        cal.add(12, delta);
        return cal;
    }

}
