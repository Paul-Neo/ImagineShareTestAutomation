package com.qa.util;

public class URL {
	
	
//	private String imagineTimeProd = "https://app.imaginetime.com/";
	private String imagineTimeTestServerProd = "https://test-app.imaginetime.com/user/login"; // test  server
//	private String LexShare = "https://app.lexshare.io/user/login";	
	
	private String fileLoc = "C:\\Users\\Paul Napadao\\Desktop\\Upload Files Automation\\";
	
	public String getUrl() {
		
		return imagineTimeTestServerProd;
		
//		return imagineTimeTestServerProd;
		
//		return LexShare;
			
	}
	
	public String getFileLoc() {
			
		return fileLoc;
	}
}
