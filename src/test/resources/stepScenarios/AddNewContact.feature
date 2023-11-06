Feature: Add New Contact

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
Then Profile firm should be "Paul QA Test Firm"

@test1
Scenario: Add New Contact and delete new contact
Given User is on Client Settings Overview "Steph Curry"
#When User is on "Contacts" tab
And User navigates to "Contacts" tab
And Click Add contacts button
Then A modal should be displayed with header message "Invite client users to Steph Curry"
When User fill up add contact form
And User send an invitation to contacts
Then Contact should be added on client contacts list
When User delete the contact
Then Contact should be deleted

@test2
Scenario: Choose From Existing contact and remove contact from client
Given User is on Client Settings Overview "Lebron James"
#When User is on "Contacts" tab
And User navigates to "Contacts" tab
And Click Add contacts button
When User click choose from existing contact
And Select "Test contact1" from the contact list
And User send an invitation to contacts
When User click remove from client
Then "No client contacts" text should be displayed

