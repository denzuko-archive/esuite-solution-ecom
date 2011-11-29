package esuite.solution.ecom.app;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@Scope("session")
@Component("PreferencesBean")
@URLMapping(id="pref", pattern="/u/pref/", viewId="/userPreferences.html")
public class PreferencesBean implements PreferencesBeanProxy {

	private static final Logger logger = Logger.getLogger(PreferencesBean.class.getName());
	private ApplicationPref applicationPref = new ApplicationPref();
	private SystemPref systemPref = new SystemPref();
	private UserPref userPref = new UserPref();
	
	public PreferencesBean() {
		
	}
	
	public void load() {
		logger.debug("URL Action");
	}

	/**
	 * @return the applicationPref
	 */
	public ApplicationPref getApplicationPref() {
		return applicationPref;
	}

	/**
	 * @param applicationPref the applicationPref to set
	 */
	public void setApplicationPref(ApplicationPref applicationPref) {
		this.applicationPref = applicationPref;
	}

	/**
	 * @return the systemPref
	 */
	public SystemPref getSystemPref() {
		return systemPref;
	}

	/**
	 * @param systemPref the systemPref to set
	 */
	public void setSystemPref(SystemPref systemPref) {
		this.systemPref = systemPref;
	}

	/**
	 * @return the userPref
	 */
	public UserPref getUserPref() {
		return userPref;
	}

	/**
	 * @param userPref the userPref to set
	 */
	public void setUserPref(UserPref userPref) {
		this.userPref = userPref;
	}

}
