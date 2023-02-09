Feature: Search Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Search a Client
Given User is on All Client Workspaces page
When User search "Elavon"
And Click Go to Clients Workspace
Then Client name should be correct
And Client Workspace links should be displayed
|Files					|
|Request Lists	|
|Activity				|
|Quick Tasks		|
|Messages				|
|Details				|
|Notifications	|
|Users					|

@test2
Scenario: Case sensitive test
Given User is on All Client Workspaces page
When User search "elavon"
And Click Go to Clients Settings
Then Client name should be correct
And Clients Settigs links should be displayed
|Overview					|
|Notifications		|
|Contacts					|
|Assigned Staff		|

@test3
Scenario: Search folder
Given User is on All Client Workspaces page
When User search "Dont Delete this folder"
And Select the expected folder
Then Client Workspace links should be displayed
|Files					|
|Request Lists	|
|Activity				|
|Quick Tasks		|
|Messages				|
|Details				|
|Notifications	|
|Users					|

@test4
Scenario: Search File
Given User is on All Client Workspaces page
When User search "testfile12345.pdf"
When User Enter a client name in advance search "Elavon"
And Select the expected file
Then File name should be correct
And buttons should be displayed
|Print							|
|Share							|
|Request Signature	|
|Comment						|
And Links should also displayed
|Public Comments		|
|Private Notes			|
|Details						|
|Activity						|



