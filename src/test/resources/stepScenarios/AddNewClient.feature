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
Given User is on "Workspaces" page
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
#And Client should be added on the client list
When User select a client
#And Navigates to "Overview" tab
And User navigates to "Overview" tab
Then Clients Overview should be correct
When User is on Client Settings page
And User Selects a Client
And Click Archive
Then Selected Client should be on the archive list
When User Selects a client in the archive list
And Click Delete
Then Client Should be deleted

@test2
Scenario: Update Clients info
Given User added a new Client
#When User is on "Workspaces" page
#And Navigates to "Overview" tab
When User select a client
And User navigates to "Overview" tab
And Updates client info
Then Clients info should be updated

@test3
Scenario: Add Clients Primary Phone
Given User added a new Client
When User select a client
#And Navigates to "Overview" tab
And User navigates to "Overview" tab
And Enter Phone number
And User click set primary
Then Number should be set as primary

@test4
Scenario: Add Clients Primary Address
Given User added a new Client
When User select a client
And User navigates to "Overview" tab
And Enter Address
And User click set primary
Then Address should be set as primary


	

