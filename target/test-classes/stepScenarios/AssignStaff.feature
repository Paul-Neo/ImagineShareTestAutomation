Feature: Assign Staff

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Check notification when Assigning a Staff
Given User is on Client Settings page
When User Selects a client "Lebron James"
Then Tool Bar buttons should enabled
When User click Assign Staff button
Then A modal should be displayed with header message "Assign staff"
When User Select a Staff "Larry Bird"
And Click next button
Then Assigned staff notification settings should be displayed
|Upload a file																			|
|View a file you uploaded														|
|Download a file you uploaded												|
|Comment on a file																	|
|Complete a signature request												|
|View a signature request														|
|Send a message																			|
|Weekly reminder for incomplete signature requests	|
When Click Assign Staff button	
Then Staff should exist on Clients Assinged Staff list

@test2
Scenario: Assign then UnAssign a Staff
Given User is on Client Settings page
When User Clicks a client "QA Test"
And Assign a staff "Michael Jordan"
Then Assined staffs should be dispalyed
|Paul Napadao		|
|Larry Bird			|
|Michael Jordan	|

When User unassign a staff "Michael Jordan"
Then Staff should be removed from the list
|Paul Napadao		|
|Larry Bird			|

@test3
Scenario: Assign Multiple Staff then Unassign
Given User is on Client Settings page
When User Selects a client "Lebron James"
And User assign multiple staffs
|Staff1						|Staff2					|
|Paul Napadao			|Michael Jordan	|
Then Staffs should be assigned to client
|Paul Napadao		|
|Michael Jordan	|
When User select all assigned staffs
And Click Unassigned staff
Then Message should be displayed "No staff assigned to this client"

@test4
Scenario: Check Assigned staff counts if correct
Given User is on Client Settings page
When User get assigned staff count for "QA Test"
And Get total number of assigned staffs
Then Assign Staff counts should be correct

