Feature: All Workspaces page feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"


@skip
Scenario: Side bar links
Given User is on "All Workspaces" page
When User gets the side bar links lists
|All Workspaces	|
|All Contacts		|
|All Files			|
|Client Settings|
|Firm Settings	|
And Links count shoud be 5


