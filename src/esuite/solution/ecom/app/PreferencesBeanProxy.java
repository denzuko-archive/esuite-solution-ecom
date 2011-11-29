package esuite.solution.ecom.app;

public interface PreferencesBeanProxy {

	public ApplicationPref getApplicationPref();
	public void setApplicationPref(ApplicationPref applicationPref);
	
	public SystemPref getSystemPref();
	public void setSystemPref(SystemPref systemPref);
	
	public UserPref getUserPref();
	public void setUserPref(UserPref userPref);
	
}
