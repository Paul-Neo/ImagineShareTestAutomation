Feature: Invite New Staff

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Invite Staff and delete staff
Given User is on Firm Settings page
When User Click Members tab
And Click Invite staff button
And Create new staff
Then A modal should be displayed with header message "Invite staff members to Paul QA Test Firm"
When User Fill up Staff information
And User send an Invite
Then New Staff should be added on the list
When User click settings for selected staff member
And Select "Inactive" status
And Delete the staff member
Then Staff member count should be correct




