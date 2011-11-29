package org.javavitamins.modules.exception;

public class SystemException extends ApplicationException {

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String errorCode, String message) {
		super(errorCode, message);
	}
	
	public SystemException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode, errorSummary, errorDesc);
	}
}
