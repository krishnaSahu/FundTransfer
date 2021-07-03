package com.at.fundTransfer.utils;

import java.util.HashMap;
import java.util.Map;

public class SessionUser {

	private static Map<String, Object> sessionMap = new HashMap<>();

	private static SessionUser instanceVariable = null;

	private SessionUser() {
		super();
	}

	public static SessionUser getInstance() {
		if (instanceVariable == null) {
			instanceVariable = new SessionUser();
		}

		return instanceVariable;
	}

	public Object get(String key) {

		return sessionMap.get(key);
	}

	public Object put(String key, Object value) {

		return sessionMap.put(key, value);
	}
}
