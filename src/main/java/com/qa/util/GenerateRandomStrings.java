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
	
	public String generatePhoneNumber() {
		
		String phoneNumber = faker.phoneNumber().cellPhone().toString();	

		return phoneNumber;
	}
	
	public String generateAddress1() {
		
		String address = faker.address().streetAddress();
		
		return address;
	}
	
	public String generateAddress2() {
		
		String address2 = faker.address().buildingNumber();
		
		return address2;
	}
	
	public String generateCity() {
		
		String city = faker.address().cityName();
		
		return city;
	}
	
	public String generatePostalCode() {
		
		String postalCode = faker.address().zipCode();
		
		return postalCode;
		
	}
	
	
}


