Feature: Request Files

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Request files to General Files
Given User is on General Folder
And Select Request files
Then A modal should be displayed with header message "Request files"
When User Enter in Link Settings
|Link Setting				|Question																									|Answer				|
|Question/Answer		|What is your social security number, without the dashes?	|123456789		|
And Click Create request files link
When User Click Copy Link
Then Link should be displayed "https://app.imaginetime.com/request/file"

@test2
Scenario: Request files to Client Workspace
Given User is on Client Workspace with Client Name "Elavon"
When User navigates to Files Tab
And Select Request files
Then A modal should be displayed with header message "Request files from Elavon"
When User Select "Direct Link" in Link Settings
And Toggle Expiration date, Add Instructions and Send Emails
And User Enters the following Informations
|Instructions					|Send Emails				|Email Message			|Recieve Emails								|
|Please upload a file	|Paul Contact				|Test Message				|paul.napadao@narrasoft.com		|
And Click Create request files link
When User Click Copy Link
Then Link should be displayed "https://app.imaginetime.com/request/file"

@test3
Scenario: Add a new folder when choose a file upload location
Given User is on Client Workspace "Avalon Systems"
When User navigates to Files Tab
And Select Request files
Then Workspace location should be "Avalon Systems"
When User click Select Folder
And Add a new folder
When User Select "Direct Link" in Link Settings
And Click Create request files link
When User Click Copy Link
Then Link should be displayed "https://app.imaginetime.com/request/file"

