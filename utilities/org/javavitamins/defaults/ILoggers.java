package org.javavitamins.defaults;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface ILoggers extends IContextNames {

	final Log javaVitaminsLogger = LogFactory.getLog(JAVA_VITAMINS_LOGGER);
	final Log enterpriseCoreLogger = LogFactory.getLog(ENTERPRISE_CORE);
	final Log enterpriseSolutionLogger = LogFactory.getLog(ENTERPRISE_SOLUTION);
	
}
