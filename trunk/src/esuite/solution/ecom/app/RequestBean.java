package esuite.solution.ecom.app;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;

@ManagedBean(name="RequestBean")
@RequestScoped
@URLMapping(id = "req", viewId = "/welcome.html", pattern = "/req/")
public class RequestBean implements RequestBeanProxy {

	private static final Logger logger = Logger.getLogger(PreferencesBean.class.getName());
	@URLQueryParameter("postID")
	private Long currentPostId;

	@URLAction
	  public void render() throws IOException {
		  logger.debug("Request Bean URL Action " + currentPostId);

	  }

	/**
	 * @return the currentPostId
	 */
	public Long getCurrentPostId() {
		return currentPostId;
	}

	/**
	 * @param currentPostId the currentPostId to set
	 */
	public void setCurrentPostId(Long currentPostId) {
		this.currentPostId = currentPostId;
	}
}
