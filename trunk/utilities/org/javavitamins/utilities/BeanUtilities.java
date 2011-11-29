package org.javavitamins.utilities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

import org.javavitamins.defaults.IContextNames;
import org.javavitamins.defaults.IDefaults;
import org.javavitamins.defaults.ILoggers;
import org.javavitamins.defaults.IOperationStatus;
import org.javavitamins.manager.ApplicationLookupManager;
import org.javavitamins.utilities.file.FileUtils;

public class BeanUtilities implements IDefaults, IContextNames, ILoggers, IOperationStatus {
	
	
	public BeanUtilities() {
		
	}
	
	public static void main(String[] args) {
//		System.out.println(new BeanUtilities().getBDValue("2"));
//		
//		BeanUtilities util = new BeanUtilities();
//		long t = System.currentTimeMillis();
//		System.out.println(t);
//		String dateLocale = util.getFormattedDateTimeLocaleValue(util.getValue(t));
//		System.out.println(dateLocale);
//		
//		Date date = new Date(dateLocale);
//		System.out.println(date);
//		
//		String s1 = util.getTimeInMilliSeconds(dateLocale);
//		System.out.println(s1);
//		
//		int r = (int) (Math.random()*10);
//		System.out.println("R" + r);
		
		System.out.println(BeanUtilities.fillUp("5", 7, "0"));
	}
	
	final public String getCurrencyValue(Object str) {
		if(null == str) {
			return BLANK;			
		}
		return str.toString().trim() + ".00";
	}
	
	final public static String getValue(Object str) {
		try {
			if(null == str) {
				return BLANK;			
			}
			return str.toString().trim();			
		} catch(Exception e) {
			e.printStackTrace();
			return BLANK;
		}
	}
	
	final public static BigDecimal getBDValue(Object str) {		
		try {
			
			BigDecimal bd = new BigDecimal(0);
			if(getValue(str).equalsIgnoreCase(BLANK)) {
				return bd;			
			}
			
			BigDecimal value = new BigDecimal(getValue(str));
			return value;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	final public static Double getDoubleValue(Object value) {		
		try {
			double doubleValue = 0;
			if (getValue(value).equalsIgnoreCase(BLANK)) {
				return doubleValue;
			}
			
			try {
				doubleValue = Double.parseDouble(getValue(value));
			} catch (NumberFormatException nfe) {
				throw nfe;
			}
			return doubleValue;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	final public static Boolean getBoolValue(Object str) {
		Boolean rVal = new Boolean(false);
		try {			
			if(getValue(str).equalsIgnoreCase(BLANK)) {
				return rVal;			
			}
			
			rVal = new Boolean(getValue(str)); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rVal;
	}
	
	final public static Boolean getOrgBoolValue(Object str) {
		Boolean rVal = new Boolean(false);
		try {			
			if(getValue(str).equalsIgnoreCase(BLANK)) {
				return null;			
			}
			
			rVal = new Boolean(getValue(str)); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rVal;
	}
	
	final public static int getIntValue(Object str) {		
		try {			
			if(getValue(str).equalsIgnoreCase(BLANK)) {
				return 0;			
			}			
			int rVal = Integer.parseInt(getValue(str));			
			return rVal;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	final public Long getLongValue(Object str) {		
		try {
			
			Long longVal = new Long(0);
			if(getValue(str).equalsIgnoreCase(BLANK)) {
				return longVal;			
			}
			
			longVal = Long.valueOf(getValue(str));
			return longVal;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	final public String getFormattedDateValue(String str) {
		if(null == str || str.equalsIgnoreCase(BLANK)) {
			return BLANK;			
		}
		
		Date date = new Date();
		try {
			date.setTime(new Long(str).longValue());
			return date.getDate() + "/" + date.getMonth() + "/" + date.getSeconds();								
		} catch(Exception e) {
			e.printStackTrace();
			return BLANK;
		}
	}
	
	final public String getFormattedDateTimeLocaleValue(String str) {
		if(null == str || str.equalsIgnoreCase(BLANK)) {
			return BLANK;			
		}
		
		Date date = new Date();
		try {
			date.setTime(new Long(str).longValue());
			return date.toLocaleString();								
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();	
		}
		return BLANK;
	}
	
	final public String getTimeInMilliSeconds(String str) {
		if(null == str || str.equalsIgnoreCase(BLANK)) {
			return BLANK;			
		}
				
		try {
			Date date = new Date(str);
			return getValue(date.getTime());								
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();	
		}
		return BLANK;
	}
	
	public static Double convertToDobule(String value) {
		Double doubleValue = null;
		if (!getValue(value).equalsIgnoreCase(BLANK)) {
			StringTokenizer strToken = new StringTokenizer(value, ",");
			String strTokenValue = "";
			while (strToken.hasMoreTokens()) {
				strTokenValue = strTokenValue + strToken.nextToken();
			}
			doubleValue = Double.valueOf(strTokenValue);
		}
		return doubleValue;
	}
	
	public static Long convertToLong(String value) {
		Long longValue = null;
		if (!getValue(value).equalsIgnoreCase(BLANK)) {
			StringTokenizer strToken = new StringTokenizer(value, ",");
			String strTokenValue = "";
			while (strToken.hasMoreTokens()) {
				strTokenValue = strTokenValue + strToken.nextToken();
			}
			longValue = new Long(Double.valueOf(strTokenValue).longValue());
		}
		return longValue;
	}
	
	public static String fillUp(String value, int limit, String prefix) {
		String temp = "";
		if (value.length() <= limit) {
			for (int i = 0; i < limit - value.length(); i++) {
				temp = temp + prefix;
			}
		}
		value = temp += value;
		return value;
	}

	private final static String removeChar(String s, char c) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c)
				r += s.charAt(i);
		}
		return r;
	}
	
	public String loadAppProperties(String realPath, String applicationConfigFile) {
		Properties properties = FileUtils.loadFile(realPath + "\\"+ applicationConfigFile);
		enterpriseSolutionLogger.debug("Application properties loaded for the file with fully qualified path as : "+realPath+"\\"+applicationConfigFile+" with values as : " + properties);
		ApplicationLookupManager applicationLookupManager = ApplicationLookupManager.getInstance();
		applicationLookupManager.appendApplicationProperties(properties);
		return _SUCCESS;
	
	}
}
