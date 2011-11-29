package org.javavitamins.defaults;

public interface IOperationStatus {

	public static final String _TRANSACTIONAL_STATUS = "TRANSACTIONAL_STATUS"; 
	
	public static final String _SUCCESS = "Success";
	public static final String _KOTSUCCESS = "KotSuccess";
	public static final String _FAILED = "Failed";
	public static final String _FATAL = "Fatal";
	public static final String _CANCEL = "Cancel";
	
	public static final String _VALIDATION_FAILURES = "ValidationFailures";
	
	public static final String _BUSINESS_ERROR = "BusinessError";
	public static final String _BUSINESS_WARNING = "BusinessWarning";
	public static final String _SYSTEM_ERROR = "SystemError";
	
	public static final String _DATA_FATAL = "DBFatal";
	public static final String _LDAP_FATAL = "LDAPFatal";
	
	public static final String _ADMIN_SUCCESS = "AdminSuccess";
	public static final String _USER_SUCCESS = "UserSuccess";
	public static final String _MANAGER_SUCCESS = "ManagerSuccess";
	public static final String _ADMIN_FAILED = "AdminFailed";
	public static final String _USER_FAILED = "UserFailed";
	public static final String _MANAGER_FAILED = "ManagerFailed";
}