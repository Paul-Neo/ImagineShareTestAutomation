Feature: Add New Client Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Add New Client
Given User is on Client Settings page
When User clicks new client button
And Clicks Create new client
Then A modal should be displayed with header message "New client"
When User enters client information
|Name								|Client Identifier		|Assign Staff			|Engagement Types	|
|Thomas Shelby			|Peaky Blinders				|Paul Napadao			|1040							|
And Click Next
Then Staff Notification should be displayed
|Upload a file																				|
|View a file you uploaded															|
|Download a file you uploaded													|
|Comment on a file																		|
|Complete a signature request													|
|View a signature request															|
|Send a message																				|
|Weekly reminder for incomplete signature requests		|
And Client should be added on the client list
And Clients Overview should be correct

@test2
Scenario: Delete a Client
Given User is on Client Settings page
When User Selects a Client "Thomas Shelby"
And Click Archive
Then Selected Client should be on the archive list
When User Selects a client in the archive list
And Click Delete
Then Client Should be deleted


	

