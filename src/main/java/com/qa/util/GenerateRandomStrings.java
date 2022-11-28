package com.qa.util;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomStrings {

	
	public String randomString(int numberOfChar) {
		
		 String generatedString = RandomStringUtils.randomAlphabetic(numberOfChar);
		 
		 return generatedString;
		 
		
	}
}
