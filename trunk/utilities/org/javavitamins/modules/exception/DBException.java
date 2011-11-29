package org.javavitamins.modules.exception;

public class DBException extends ApplicationException {

	public DBException(String message) {
		super(message);
	}

	public DBException(String errorCode, String message) {
		super(errorCode, message);
	}
	
	public DBException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode, errorSummary, errorDesc);
	}
}
