package org.javavitamins.web;

import javax.servlet.http.HttpServletRequest;

public class BrowserSniffer {

	public static boolean acceptsGzip(HttpServletRequest req) {
		String acceptEncoding = req.getHeader("Accept-Encoding");
		return acceptEncoding != null && acceptEncoding.indexOf("gzip") != -1;
	}

	public static boolean is_ie(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return agent.indexOf("msie") != -1;
	}

	public static boolean is_ie_4(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return is_ie(req) && agent.indexOf("msie 4") != -1;
	}

	public static boolean is_ie_5(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return is_ie(req) && agent.indexOf("msie 5.0") != -1;
	}

	public static boolean is_ie_5_5(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return is_ie(req) && agent.indexOf("msie 5.5") != -1;
	}

	public static boolean is_ie_5_5_up(HttpServletRequest req) {
		return is_ie(req) && !is_ie_4(req) && !is_ie_5(req);
	}

	public static boolean is_linux(HttpServletRequest req) {
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return agent.matches(".*linux.*");
	}

	public static boolean is_mozilla(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return agent.indexOf("mozilla") != -1 && agent.indexOf("spoofer") == -1
				&& agent.indexOf("compatible") == -1
				&& agent.indexOf("opera") == -1 && agent.indexOf("webtv") == -1
				&& agent.indexOf("hotjava") == -1;
	}

	public static boolean is_mozilla_1_3_up(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		if (is_mozilla(req)) {
			int pos = agent.indexOf("gecko/");
			if (pos == -1)
				return false;
			String releaseDate = agent.substring(pos + 6, agent.length());
			if (releaseDate.compareTo("20030210") > 0)
				return true;
		}
		return false;
	}

	public static boolean is_ns_4(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return !is_ie(req) && agent.indexOf("mozilla/4.") != -1;
	}

	public static boolean is_rtf(HttpServletRequest req) {
		return is_ie_5_5_up(req) || is_mozilla_1_3_up(req);
	}

	public static boolean is_safari(HttpServletRequest req) {
		if (req == null)
			return false;
		String agent = req.getHeader("User-Agent");
		if (agent == null)
			return false;
		agent = agent.toLowerCase();
		return agent.indexOf("safari") != -1;
	}

	public static boolean is_wml(HttpServletRequest req) {
		if (req == null)
			return false;
		String accept = req.getHeader("ACCEPT");
		if (accept == null)
			return false;
		accept = accept.toLowerCase();
		return accept.indexOf("wap.wml") != -1;
	}

	public BrowserSniffer() {
	}

	private static final String _GZIP = "gzip";

}
