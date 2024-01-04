Feature: Download files

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@skip
Scenario: Download a file #need to add step for date range
Given User is on "Workspaces" page
When User search "Automation test file.pdf"
And Select the expected file
Then File name should be correct
When User click download button
Then File should be downloaded

@test2
Scenario: download a folder from a client
Given User is on Client Workspace "QA Test"
When User download "Dont Delete this folder" folder
Then folder should be downloaded as zip file

@test3
Scenario: download all files
Given User is on Client Workspace "Lebron James"
#Given User is on "Workspaces" page
#When User Selects a client "Steph Curry"
When User tick all checkbox
And Click download button
Then Files should be downloaded as zip file


@test4
Scenario: Download multiple files
Given User is on Client Workspace "Elavon"
When User Select a file "Automation file download 1"
And User Select a file "Automation file download 2"
And Click download button
Then folder should be downloaded as zip file

