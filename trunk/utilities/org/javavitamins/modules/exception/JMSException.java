package org.javavitamins.modules.exception;

public class JMSException extends ApplicationException {

	public JMSException(String message) {
		super(message);
	}

	public JMSException(String errorCode, String message) {
		super(errorCode, message);
	}
	
	public JMSException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode, errorSummary, errorDesc);
	}
}
