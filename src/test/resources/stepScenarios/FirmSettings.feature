Feature: Firm Settings

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"

@test1
Scenario: Cancel firm Subscription
Given User is on accounts page
Then Firms should be displayed
|Avalon Systems								|
|QA Test											|
|ImagineTime									|
|IS - Mangobilling Test Firm	|
|Paul QA Test Firm						|
When User Go to Admin
And Click a firm "Paul QA Test Firm"
And Update subscription status "Canceled"
Then Firms should be displayed
|ImagineTime									|
|IS - Mangobilling Test Firm	|


@test2
Scenario: Activate firm subscription
Given User is on accounts page
Then Firms should be displayed
|ImagineTime									|
|IS - Mangobilling Test Firm	|
When User Go to Admin
And Click a firm "Paul QA Test Firm"
And Update subscription status "Trialing"
Then Firms should be displayed
|Avalon Systems								|
|QA Test											|
|ImagineTime									|
|IS - Mangobilling Test Firm	|
|Paul QA Test Firm						|


@test3
Scenario: Check Firm Settings Page
Given User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "Paul QA Test Firm"
And Profile firm should be "Paul QA Test Firm"
When User is on Firm Settings page
Then Links should be displayed
|Overview							|
|Members							|
|Custom Tags					|
|Advanced Settings		|
|Folder Templates			|
|Integrations					|









