Feature: All Workspaces page feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@2test1
Scenario: Side bar links
Given User is on "Workspaces" page
When User gets the side bar links lists
|Workspaces			|
|Contacts				|
|Files					|
|Firm Settings	|
|Help						|
And Links count shoud be 5


