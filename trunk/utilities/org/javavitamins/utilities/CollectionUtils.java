package org.javavitamins.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CollectionUtils extends BeanUtilities {

	
	public static boolean containsString(String key, List list) {
		javaVitaminsLogger.info("Entering - containsString()");
		boolean available = false;
		if (null != list && !list.isEmpty() && !getValue(key).equalsIgnoreCase(BLANK)) {
			Iterator i = list.iterator();
			while (i.hasNext()) {
				Object object = i.next();
				if (null != object && object instanceof String) {
					String obj = (String) object;
					if (getValue(obj).equalsIgnoreCase(getValue(key))) {
						available = true;
					}
				}
			}
		}
		javaVitaminsLogger.info("Exiting - containsString() :: available:" + available);
		return available;
	}
	
	public static boolean removeKey(String key, List list) {
		javaVitaminsLogger.info("Entering - removeKey()");
		boolean operationStatus = false;
		if (null != list && !list.isEmpty() && !getValue(key).equalsIgnoreCase(BLANK)) {
			Iterator i = list.iterator();
			while (i.hasNext()) {
				Object object = i.next();
				if (null != object && object instanceof String) {
					String obj = (String) object;
					if (getValue(obj).equalsIgnoreCase(getValue(key))) {
						operationStatus = true;
						i.remove();
					}
				}
			}
		}
		javaVitaminsLogger.info("Exiting - removeKey() :: operationSttaus:" + operationStatus);
		return operationStatus;
	}
	
	public static Map convertStringToMap(String strValue) {
		Map fieldAttributeMap = new HashMap();
		StringTokenizer token = new StringTokenizer(strValue, ";");
		while (token.hasMoreElements()) {
			String element = getValue(token.nextElement());
			// LoggerUtils.printLog(element);
			StringTokenizer elementToken = new StringTokenizer(element, ":");
			String key = "", value = "";
			if (elementToken.hasMoreElements()) {
				key = getValue(elementToken.nextElement());
			}
			if (elementToken.hasMoreElements()) {
				value = getValue(elementToken.nextElement());
			}
			fieldAttributeMap.put(key, value);
		}
		return fieldAttributeMap;
	}
	
	public static Collection getCollectionFromString(String strValue, String delimiter) {
		Collection valueCollection = new ArrayList();
		if (strValue != null) {
			if (!getValue(strValue).equalsIgnoreCase(BLANK)) {
				StringTokenizer strTokenizer = new StringTokenizer(strValue, delimiter);
				while (strTokenizer.hasMoreTokens()) {
					valueCollection.add(strTokenizer.nextToken());
				}
			}
		}
		return valueCollection;
	}

	
}
