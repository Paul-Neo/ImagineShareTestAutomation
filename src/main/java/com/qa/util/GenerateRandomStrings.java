package com.qa.util;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class GenerateRandomStrings {

	
	Faker faker = new Faker();
	
	public String randomString(int numberOfChar) {
		
		 String generatedString = RandomStringUtils.randomAlphabetic(numberOfChar);
		 
		 return generatedString;
		 
	}
	
	public String generateFirstName() {
		
		String firstName = faker.name().firstName();
		
		return firstName;
		
	}
	
	public String generateLastName() {
		
		String lastName = faker.name().lastName();
		
		return lastName;
	}
	
	public String generateFullName(){
		
		String fullName = faker.name().fullName();
		
		return fullName;
	}
	
	public String generateEmailAddress(String firstName, String lastName) {
		
		String emailAddress = firstName + lastName + "test@gmail.com";
		
		return emailAddress;
	}
}


