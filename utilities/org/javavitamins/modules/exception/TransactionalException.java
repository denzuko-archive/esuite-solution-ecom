package org.javavitamins.modules.exception;

public class TransactionalException extends ApplicationException {

	public TransactionalException(String message) {
		super(message);
	}

	public TransactionalException(String errorCode, String message) {
		super(errorCode, message);
	}
	
	public TransactionalException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode, errorSummary, errorDesc);
	}
		
}
