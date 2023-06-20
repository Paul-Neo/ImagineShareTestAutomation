Feature: Page Navigation
Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"

Scenario: Navigate on Archive pages in General files
Given User is on General Folder
When User go to archive list
Then Column Headers should be displayed
|Filename		|
|Created By	|
|Date				|
When Filter per "25" pages
And User get the label
Then label should contains "Showing 1-25"
