Feature: Add New Tag

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"


@test1
Scenario Outline: Add New Tag
Given User is on Firm Settings page
When User is on "Custom Tags" tab
And Click new tag button
Then A modal should be displayed with header message "New custom tag"
When User enter a name "<Name>"
When Select a type "<Type>"
And Click create custom tag button
Then The new tag should be added on the custom tags list
Examples:
|Name			|Type		|
|QA Test	|Other	|



