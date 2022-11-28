Feature: Add New Client Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|


Scenario: Check User Profile Dropdown
Given User is on Admin Page
And Clicks user profile dropdown
Then Dropdown menu should be correct