package com.qa.util;

public class URL {
	
	
//	private String imagineTimeProd = "https://app.imaginetime.com/";
	private String imagineTimeTestServerProd = "https://test-app.imaginetime.com/user/login";
//	private String LexShare = "https://app.lexshare.io/user/login";	
	
//	private String fileLoc = "C:\\Users\\Paul Napadao\\Desktop\\Upload Files Automation\\";
	private String fileLoc = "C:\\Automation Files\\";

	
	public String getUrl() {
		
//		return imagineTimeProd;
		
		return imagineTimeTestServerProd;
		
//		return LexShare;
			
	}
	
	public String getFileLoc() {
			
		return fileLoc;
	}
}
