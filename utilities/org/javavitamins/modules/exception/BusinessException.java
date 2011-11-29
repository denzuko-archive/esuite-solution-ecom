package org.javavitamins.modules.exception;

public class BusinessException extends ApplicationException {

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String errorCode, String message) {
		super(errorCode, message);
	}
	
	public BusinessException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode, errorSummary, errorDesc);
	}
		
}
