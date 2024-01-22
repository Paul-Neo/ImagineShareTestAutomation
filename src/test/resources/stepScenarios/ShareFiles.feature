@CreateLinksRegressionTest
Feature: Share Files Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Navigate to General Files folder
Given User is on All Files page
When User select "General Files" folder
Then Files/Folders in General Files should be displayed on the lists
And Tool bar buttons should exist
|Tags							|
|Move							|
|Download					|
|Archive					|
|New Link					|
|New Folder				|
|New File					|

@test2
Scenario: Share a Single File on General Files using Question/Answer link setting
Given User is on General Folder
When User Select a file "share file test.pdf"
And Select Share files
Then A modal should be displayed with header message "Share files"
When User Enter in Link Settings
|Link Setting				|Question																									|Answer				|
|Question/Answer		|What is your social security number, without the dashes?	|123456789		|
And Click Create Share Link button
Then Selected file should be displayed
When User Click Copy Link
Then Link should be displayed

@test3
Scenario: Share a Single File on General Files using Direct Link in link setting
Given User is on General Folder
When User Select a file "share file test.pdf"
And Select Share files
Then A modal should be displayed with header message "Share files"
When User Select "Direct Link" in Link Settings
And Toggle Expiration date and Send Emails
When User select a contact in dropdown and send a Email Message
|Recipient Name			|Email Message			|
|Paul Napadao				|Email Message Test	|
And Click Create Share Link button
Then Selected file should be displayed
When User Click Copy Link
Then Link should be displayed

@test4
Scenario: Share a Single File on Clients Workspace
Given User is on Client Workspace "Avalon Systems"
When User Clicks a PDF file
And Clicks Share button
When User Enter in Link Settings
|Link Setting				|Question																									|Answer				|
|Question/Answer		|What is your social security number, without the dashes?	|123456789		|
And Click Create Share Link button
When User Click Copy Link
Then Link should be displayed



