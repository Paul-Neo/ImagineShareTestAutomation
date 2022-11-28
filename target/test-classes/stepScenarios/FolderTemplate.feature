Feature: Folder Template

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Add New Template
Given User is on Firm Settings page
When User is on "Folder Templates" tab
And Click New Template button
Then Create Template window should be displayed with header message "Create Template"
When User Enters Template info
|Name									|Description		|Delegated Admin		|
|Pauls Template 2022	|For Test Only	|Larry Bird					|
And Click create template
Then New template should be added on the list

@test2
Scenario: Delete Template
Given User is on Firm Settings page
When User is on "Folder Templates" tab
And Select a Folder Template
And Choose Delete from ellipis menu
Then Alert Message should be displayed with header message "Delete"
And Template name should be "Pauls Template 2022"
When User Click Ok
Then Template should be deleted from the list
|Paul Template2|
|Paul Template1|

@test3
Scenario: Apply Folder Template on General Files
Given User is on General Folder
When User Select Apply folder template
Then A modal should be displayed with header message "Apply folder template"
When User Click Select folder template button
And User selects "Paul Template2" 
And Click Done
Then Selected template should be ready to apply
When User click Apply Template button
Then Folder template should be applied
And Folders count should be correct

@test4
Scenario: Apply Folder Template on Client Workspace
Given User is on Client Workspace "Avalon Systems"
When User Select Apply folder template
Then A modal should be displayed with header message "Apply folder template"
When User Click Select folder template button
And User selects "Paul Template2" 
And Click Done
Then Selected template should be ready to apply
When User click Apply Template button
Then Folder template should be applied
And Folders count should be correct

@test5
Scenario: Apply Folder Template on Personal Files
Given User is on Personal File "Paul Napadao"
When User Select Apply folder template
Then A modal should be displayed with header message "Apply folder template"
When User Click Select folder template button
And User selects "Paul Template2" 
And Click Done
Then Selected template should be ready to apply
When User click Apply Template button
Then Folder template should be applied
And Folders count should be correct











