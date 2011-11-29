package org.javavitamins.modules.exception;

public class ApplicationException extends Exception {

	private String errorCode;
	private String errorSummary;
	private String errorDesc;
	
	public ApplicationException() {
		this.errorCode = "";
		this.errorSummary = "";
		this.errorDesc = "";
	}

	public ApplicationException(String errorCode) {
		super(errorCode); // TODO fetch the exact error message
		this.errorCode = errorCode;		
	}

	public ApplicationException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;		
	}
	
	public ApplicationException(String errorCode, String errorSummary, String errorDesc) {
		super(errorCode); // TODO fetch the exact error message
		this.errorCode = errorCode;
		this.errorSummary = errorSummary;
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorSummary
	 */
	public String getErrorSummary() {
		return errorSummary;
	}

	/**
	 * @param errorSummary the errorSummary to set
	 */
	public void setErrorSummary(String errorSummary) {
		this.errorSummary = errorSummary;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	

}
