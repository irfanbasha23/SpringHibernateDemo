package com.example.demo.evaluator;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator{

	public boolean hasPermission(Authentication authentication, Object accessType, Object permission) {
		if (authentication != null && accessType instanceof String) {
			if ("ROLE".equalsIgnoreCase(String.valueOf(accessType))) {
				boolean hasAccess = validateAccess(String.valueOf(permission));
				return hasAccess;
			}
			return false;
		}
		return false;
	}
	
	private boolean validateAccess(String permission) {
		// ideally should be checked with user role, permission in database
		if ("HR".equalsIgnoreCase(permission)) {
			return true;
		}
		return false;
	}

	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
