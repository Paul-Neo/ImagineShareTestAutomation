Feature: File Versioning feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"


@test1
Scenario: Check File Versions on General folder
Given File versioning is switched to "Enable File Versioning"
When User is on General Folder
Then Versions column should be displayed
When User clicks file a version icon
Then A modal should be displayed with header message "File Versions"
And User selects a file version
Then All buttons should be enabled
|Download — 1	|
|Archive — 1	|
|Cancel				|


@test2
Scenario: Check File Versions on Client Workspace
Given File versioning is switched to "Enable File Versioning"
When User is on Client Workspace "Avalon Systems"
Then Versions column should be displayed
When User clicks file a version icon
Then A modal should be displayed with header message "File Versions"
And User selects a file version
Then All buttons should be enabled
|Download — 1	|
|Archive — 1	|
|Cancel				|

@test3
Scenario: Check File Versions on Personal folder
Given File versioning is switched to "Enable File Versioning"
When User is on Personal File "Paul Napadao"
Then Versions column should be displayed
When User clicks file a version icon
Then A modal should be displayed with header message "File Versions"
And User selects a file version
Then All buttons should be enabled
|Download — 1	|
|Archive — 1	|
|Cancel				|

@test4
Scenario: Disabled File Versioning
Given File versioning is switched to "Disable File Versioning"
When User is on General Folder
Then Version column should not be displayed
|Filename				|
|Size						|
|Folders				|
|Files					|
|Tags						|
|Visibility			|
|Created By			|
|Last Updated		|






