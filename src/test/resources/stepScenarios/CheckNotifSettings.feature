Feature: Notification Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

Scenario: Check Notification Settings
Given User is on Client Settings Overview "Elavon"
#And User is on "Notifications" tab
And User navigates to "Notifications" tab
Then Notification settings should be displayed
|Upload a file																			|
|View a file they uploaded													|
|Download a file they uploaded											|
|Comment on a file																	|
|Send a message																			|
|Weekly reminder for incomplete signature requests	|
|Upload a file																			|
|View a file you uploaded														|
|Download a file you uploaded												|
|Comment on a file																	|
|Complete a signature request												|
|View a signature request														|
|Send a message																			|
|Weekly reminder for incomplete signature requests	|

