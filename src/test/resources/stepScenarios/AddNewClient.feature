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
Scenario: Add New Client and delete client
Given User is on Client Settings page
When User clicks new client button
And Clicks Create new client
Then A modal should be displayed with header message "New client"
When User enters client information
|Assign Staff			|Engagement Types	|
|Paul Napadao			|1040							|
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
Given User is on Client Settings page
When User Selects a Client
And Click Archive
Then Selected Client should be on the archive list
When User Selects a client in the archive list
And Click Delete
Then Client Should be deleted

@test2
Scenario: Update Clients info
Given User added a new Client
When User select a client
And Updates client info
Then Clients info should be updated


	

