package org.javavitamins.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;

public class LogUtils {

	public static final int STACK_TRACE_LENGTH = 20;
	public static final boolean REMOVE_UNKNOWN_SOURCE = true;

	public LogUtils() {
	}

	public static void log(Log log, Throwable t) {
		if (t instanceof JspException)
			log(log, (JspException) t);
		else if (t instanceof ServletException) {
			log(log, (ServletException) t);
		} else {
			Throwable cause = t.getCause();
			if (cause != null)
				log(log, cause);
			else
				_log(log, t);
		}
	}

	public static void log(Log log, JspException jspe) {
//		Throwable cause = jspe.getRootCause();
//		if (cause == null)
//			cause = jspe;
//		if (cause != jspe && (cause instanceof JspException))
//			log(log, (JspException) cause);
//		else if (cause instanceof ServletException)
//			log(log, (ServletException) cause);
//		else
//			_log(log, cause);
	}

	public static void log(Log log, ServletException se) {
		Throwable cause = se.getRootCause();
		if (cause == null)
			cause = se;
		if (cause instanceof JspException)
			log(log, (JspException) cause);
		else if (cause != se && (cause instanceof ServletException))
			log(log, (ServletException) cause);
		else
			_log(log, cause);
	}

	private static final void _log(Log log, Throwable cause) {
		StackTraceElement steArray[] = cause.getStackTrace();
		if (steArray.length > 20) {
			int count = 0;
			List steList = new ArrayList();
			for (int i = 0; i < steArray.length; i++) {
				StackTraceElement ste = steArray[i];
				String className = ste.getClassName();
				boolean addElement = true;
				if (ste.getLineNumber() < 0)
					addElement = false;
				if (className.startsWith("$")
						|| className.startsWith("java.lang.reflect.")
						|| className.startsWith("org.springframework.")
						|| className.startsWith("sun.reflect."))
					addElement = false;
				if (addElement) {
					steList.add(ste);
					count++;
				}
				if (count >= 20)
					break;
			}

			steArray = (StackTraceElement[]) steList
					.toArray(new StackTraceElement[0]);
			cause.setStackTrace(steArray);
		}
//		log.error(StackTraceUtils.getStackTrace(cause)); TODO
	}

}
