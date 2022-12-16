Feature: File Preview

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Preview a pdf file in General files
Given User is on General Folder
When User Clicks a PDF file
Then buttons and links should be displayed
And Title page should be "File Preview"

@test2 @skip
Scenario: Preview a pdf file in client workspace then check tags and Associated Clients
Given User is on Client Workspace "Elavon"
When User Clicks a PDF file
And Click Details link
Then Default associated client should be correct
And Tags should be displayed

@test3
Scenario: Move a file through associated clients in client workspace
Given User is on Client Workspace "QA Test"
When User Clicks a PDF file
And Click Details link
When User selects associated client "Avalon Systems"
Then file should be moved on selected associated client

@test4
Scenario: Move a file through associated clients in General Folder
Given User Uploaded a file in General Files "Delete.pdf"
When User Clicks a PDF file
And Click Details link
When User selects associated client "Lebron James"
Then file should be moved on selected associated client

@test5
Scenario: Move a file through associated clients in Personal Files
Given User is on Personal File "Paul Napadao"
When User Clicks a PDF file
And Click Details link
When User selects associated client "QA Test"
Then file should be moved on selected associated client

@test6
Scenario: PDF Editor in General Files
Given Pdf editor is toggled on
And User is on General Folder
When User Clicks a PDF file
And User Click Edit pdf icon
Then File should be ready to edit
And PDFtron toolbar buttons should be displayed
|Underline								|
|Highlight								|
|Rectangle								|
|Free Text								|
|Free Hand Highlight			|
|Free Hand								|
|Note											|
|Squiggly									|
|Strikeout								|

