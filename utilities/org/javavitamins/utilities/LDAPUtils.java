package org.javavitamins.utilities;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

public class LDAPUtils {

	public LDAPUtils() {
	}
	
	public static String getAttributeValue(Attributes attrs, String id)
			throws NamingException {
		return getAttributeValue(attrs, id, id);
	}

	public static String getAttributeValue(Attributes attrs, String id,
			String defaultValue) throws NamingException {
		try {

			Object obj;
			Attribute attr = attrs.get(id);
			obj = attr.get();
			return obj.toString();

		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}

		return defaultValue;
	}	

}
