Feature: Login Page Feature

@test1
Scenario: Get Login page title
Given User is on login page
When User gets the title of the page
Then Title page should be "Login to ImagineTime"

@test2
Scenario: Login with correct credentials
Given User is on login page
When User enters correct email address "paul.napadao@narrasoft.com"
And User enters correct password "Pnnwfh2021!" and User gets the title of the page
And Clicks Sign In button
Then Title page should be "Select Your Account"

@test3 @skip
Scenario: Login with Two Factor Authentication
Given User turned on the Two Factor Authentication
|User Name										|Password			|
|paul.napadao@narrasoft.com		|Pnnwfh2021!	|
When User is on login page
When User enters correct email address "paul.napadao@narrasoft.com"
And User enters correct password "Pnnwfh2021!" and User gets the title of the page
And Clicks Sign In button
Then Two Factor Authentication displayed
When User enter correct six digit code
And Click verify
Then User will login successfully 
And Title page should be "Select Your Account"
When User turned off the Two Factor Authentication
Then Enable TFA button should be displayed

@test4
Scenario: Login with incorrect credentials
Given User is on login page
When User enters wrong email address "wrongEmail@gmail.com"
And User enters wrong password "wrongPassword"
And Clicks Sign In button
Then Error message should be displayed "Error with sign in"
And User clicks try again button

@test5
Scenario: Check login page components
Given User is on login page
When User clicks forgot password
Then Title page should be "Forgot Password"
And Forgot password window should be displayed
When User clicks back to login 
Then Title page should be "Login to ImagineTime"
And Sign in with Microsoft should be displayed
