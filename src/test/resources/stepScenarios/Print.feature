Feature: Print

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Print a file in General Files
Given User is on General Folder
When User Clicks a PDF file
And Click Print
Then File should be ready for print

@test2
Scenario: Print a file in Client Workspace
Given User is on Client Workspace "Avalon Systems"
When User Clicks a PDF file
And Click Print
Then File should be ready for print

@test3
Scenario: Print a file in Personal File
Given User is on Personal File "Paul Napadao"
When User Clicks a PDF file
And Click Print
Then File should be ready for print

@test4
Scenario: Print a file inside a folder
Given User is inside a folder
When User Clicks a PDF file
And Click Print
Then File should be ready for print

