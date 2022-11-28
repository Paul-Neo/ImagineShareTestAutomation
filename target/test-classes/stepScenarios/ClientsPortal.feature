Feature: Clients Portal

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paulnapadaotest@gmail.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul Automation"
Then Profile firm should be "Paul Automation"

@login
Scenario: Check Links
Given User has logged in successfully
Then Navigation Links should be displayed
|Files							|
|Dashboard					|
|Quick Tasks				|
|Request Lists			|
|Request List Tasks	|
|Message Board			|
|Account						|

@test1
Scenario: Check files if displayed
Given User is on "Files" tab
Then Files and folders should displayed
|New Folder Test123				|
|Test Sept 14							|
|Axis.pdf									|
|File Test.pdf						|

@test2
Scenario: Download a folder on Clients portal
Given User is on "Files" tab
When User download "New Folder Test123" folder
Then folder should be downloaded as zip file

@test3
Scenario: Download multiple files on Clients Portal
Given User is on "Files" tab
When User tick all checkbox
And Click download button
Then Files should be downloaded as zip file

@test4
Scenario: Check the latest message if posted
Given User has sent a message in Clients portal
|Email Address							|Password		|Subject					|Message									|
|paulnapadaotest@gmail.com	|Pnnwfh2021!|Test Automation3	|This is a message test3	|
When User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"
When User navigates to clients workspace with a Client Name "Paul Automation"
And User is on "Activity" tab
Then the latest activity should be today
And "Paul Contact sent a message" message should be displayed
When User is on "Message" tab
Then Latest Message sent from client portal should be displayed 

