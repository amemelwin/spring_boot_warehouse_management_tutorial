package com.warehouse.management.utility;

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
}
