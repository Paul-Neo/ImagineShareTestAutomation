Feature: Upload Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Upload a single file in General Files
Given User is on General Folder
When User click upload new files button
Then A modal should be displayed with header message "Upload files"
When User upload a file "Axis.pdf"
And Click upload & save button
Then The file should be uploaded

@test2
Scenario: Upload  a single file in Client Workspace
Given User is on Client Workspace "Avalon Systems"
When User click upload new files button
Then A modal should be displayed with header message "Upload files"
When User upload a file "Axis.pdf"
And Click upload & save button
Then The file should be uploaded

@test3
Scenario: Upload a single file in Personal File
Given User is on Personal File "Paul Napadao"
When User click upload new files button
Then A modal should be displayed with header message "Upload files"
When User upload a file "Axis.pdf"
And Click upload & save button
Then The file should be uploaded

@test4
Scenario: Rename a file with invalid Characters in General Files
Given User is on General Folder
When User Rename a File with invalid character
Then Warning message should be displayed "A filename can't contain any of the following characters:"


@test5
Scenario: Create a folder with invalid Characters in Client Workspace
Given User is on Client Workspace "Avalon Systems"
When User Create a folder with Invalid Characters
Then Warning message should be displayed "A folder name can't contain any of the following characters:"

@test6
Scenario: Default file upload Hidden
Given User set the defaul file upload "Hidden"
When User is on Client Workspace "Avalon Systems"
And User click upload new files button
Then A modal should be displayed with header message "Upload files"
When User upload a file "Axis.pdf"
And Click upload & save button
Then The file should be uploaded
And File should be "HIDDEN"

@test7
Scenario: Default file upload Visible
Given User set the defaul file upload "Visible"
When User is on Client Workspace "Avalon Systems"
And User click upload new files button
Then A modal should be displayed with header message "Upload files"
When User upload a file "Axis.pdf"
And Click upload & save button
Then The file should be uploaded
And File should be "VISIBLE"







