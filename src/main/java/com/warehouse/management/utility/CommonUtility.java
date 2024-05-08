package com.warehouse.management.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtility {
	
	public static int parseInt(String num) {
		try {			
			return Integer.parseInt(num);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static long parseLong(String num) {
		try {			
			return Long.parseLong(num);
		}catch(Exception e) {
			return 0;
		}
	}
	
	// Email Format validation
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    // Phone Format validation
    private static final String PHONE_REGEX = "^\\+95 \\([0-9]\\) \\d{3} \\d{4}$";

    private static final Pattern phonePattern = Pattern.compile(PHONE_REGEX);

    public static boolean isValidMyanmarPhoneNumber(String phoneNumber) {
        Matcher matcher = phonePattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    
}
