package esuite.solution.ecom.app;

public class ApplicationPref {
	
	private String appTemplate = "horizon";
	private String ecomTemplate = "ecommerce";

	public ApplicationPref() {
		
	}

	/**
	 * @return the appTemplate
	 */
	public String getAppTemplate() {
		return appTemplate;
	}

	/**
	 * @param appTemplate the appTemplate to set
	 */
	public void setAppTemplate(String appTemplate) {
		this.appTemplate = appTemplate;
	}

	/**
	 * @return the ecomTemplate
	 */
	public String getEcomTemplate() {
		return ecomTemplate;
	}

	/**
	 * @param ecomTemplate the ecomTemplate to set
	 */
	public void setEcomTemplate(String ecomTemplate) {
		this.ecomTemplate = ecomTemplate;
	}
}
