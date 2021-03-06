package com.fit2cloud.jenkins.aliyunoss;

import java.io.IOException;
import java.util.Map;

import hudson.Util;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;


public class Utils {
	public static final String FWD_SLASH = "/";
	
	public static boolean isNullOrEmpty(final String name) {
		boolean isValid = false;
		if (name == null || name.matches("\\s*")) {
			isValid = true;
		}
		return isValid;
	}
	
	public static String replaceTokens(AbstractBuild<?, ?> build,
			BuildListener listener, String text) throws IOException,
			InterruptedException {
		String newText = null;
		if (!isNullOrEmpty(text)) {
			Map<String, String> envVars = build.getEnvironment(listener);
			newText = Util.replaceMacro(text, envVars);
		}
		return newText;
	}

}