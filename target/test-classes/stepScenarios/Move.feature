Feature: Move Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"

@test1
Scenario: Move a single File in General Files to Personal File
Given User is on General Folder
When User Selects a file "Move File test.pdf"
And Click Move
Then Move window should be displayed
When User Selects "Paul Napadao | Personal files"
And Click Save
Then File should be gone in General Files and moved in Personal Files "Paul Napadao"

@test2
Scenario: Move a single File in Personal File to General FIles
Given User is on Personal File "Paul Napadao"
When User Selects a file "Move File test.pdf"
And Click Move
Then Move window should be displayed
When User Selects "(General Files)"
And Click Save
Then File should be gone in Personal Files and moved in General Files



