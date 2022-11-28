Feature: Delete Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Delete a file in General Files
Given User Uploaded a file in General Files "Delete.pdf"
When User Selects the uploaded file
And Click Archive
Then File should be moved to arhived files list
And Title page should be "Archived Files List"
When User Selects a file in archived files list
And Click Delete
Then File should be deleted

@test2
Scenario Outline: Delete a file in Clients Workspace
Given User Uploaded a file "<FileName>" in Client Workspace "<ClientWorkspace>"
When User Selects the uploaded file
And Click Archive
Then File should be moved to arhived files list
And Title page should be "Archived Files List"
When User Selects a file in archived files list
And Click Delete
Then File should be deleted
Examples:
|FileName			|ClientWorkspace		|
|Delete.pdf		|Avalon Systems			|

@test3
Scenario Outline: Delete a folder
Given User is created a folder "<FolderName>" on Client Workspace "<ClientWorkspace>"
When User selects a folder
And Click Archive
Then File should be moved to arhived files list
And Title page should be "Archived Files List"
When User Selects a file in archived files list
And Click Delete
Then File should be deleted
Examples:
|FolderName						|ClientWorkspace		|
|newDeleteFolder1			|Lebron James				|



