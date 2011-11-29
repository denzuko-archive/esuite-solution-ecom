package org.javavitamins.manager;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.javavitamins.defaults.ILoggers;
import org.javavitamins.utilities.BeanUtilities;

public class ApplicationLookupManager extends BeanUtilities {

	private static ApplicationLookupManager applicationLookupManager;
	private Properties applicationProperties = null;
	
	private ApplicationLookupManager() {
		init();
	}

	protected Object clone() throws CloneNotSupportedException {
		return null;
	}

	private void init() {
		javaVitaminsLogger.debug("Initializing Application Look-up Manager");
		applicationProperties = new Properties();
		applicationProperties.put("founder", "Israni Murli P");
		applicationProperties.put("application.id", "ESS4BMS");
		
		applicationProperties.put("report_templates_path","D:/enterprise.bizz/enterprise.bizz.core/enterprise.reports.resources/");
		applicationProperties.put("report_output_path", "F:/BMS/Output/");
	}

	public static ApplicationLookupManager getInstance() {
		if (null == applicationLookupManager) {
			applicationLookupManager = new ApplicationLookupManager();
		}
		return applicationLookupManager;
	}

	public String getProperty(String key) {
		String value = null;
		value = applicationProperties.getProperty(key);
		if (value == null) {
			System.out.println("The application property file does not have value for specified key : "
							+ key);
		}
		return getValue(value);		
	}

	/**
	 * @return the applicationProperties
	 */
	public Properties getApplicationProperties() {
		return applicationProperties;
	}

	/**
	 * @param applicationProperties
	 *            the applicationProperties to set
	 */
	public void setApplicationProperties(Properties applicationProperties) {
		this.applicationProperties = applicationProperties;
//		TODO
//		this.applicationProperties.putAll(applicationProperties);
	}
	
	public void appendApplicationProperties(Properties applicationProperties) {
		this.applicationProperties.putAll(applicationProperties);
	}

	public static void main(String[] args) {

		ApplicationLookupManager applicationLookupManager = ApplicationLookupManager.getInstance();		
		System.out.println(applicationLookupManager.getApplicationProperties());

	}

}
