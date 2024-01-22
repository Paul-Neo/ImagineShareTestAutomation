@CreateLinksRegressionTest
Feature: Request Signature Feature

Background:
Given User has already logged in to Imagine Time
|Email Address							|Password		|
|paul.napadao@narrasoft.com	|Pnnwfh2021!|
When User gets the title of the page
Then Title page should be "Select Your Account"
And User Select a firm "ImagineTime"
Then Profile firm should be "ImagineTime"

@test1
Scenario: Select file in General files for request signature
Given User is on General Folder
When User Click a file in General Files "Request Signature Test.pdf"
And User Click Request Signature
Then A modal should be displayed with header message "Prepare document for e-signature"
And File Name should be "Request Signature Test.pdf"
When User Enter in Link Settings
|Link Setting				|Question																									|Answer				|
|Question/Answer		|What is your social security number, without the dashes?	|123456789		|
And Select a template "1040 EFILES FED & CA Single"
And Enter Signer Details and Instructions
|First Name	|Last Name	|Email Address	|Instruction	|
|Paul				|Napadao		|paul@yahoo.com	|Please sign	|
And Click Prepare Request button
Then Signature Request Created
And Signer should be notified

@test2
Scenario: Search a file and request for a Joint request signature
Given User is on "Workspaces" page
When User search "Elavon Request Sig.pdf"
And User Enter a client name in advance search "Elavon"
And Select the expected file
Then Title page should be "File Preview"
When User Click Request Signature
Then Workspace location should be "Elavon"
And File Name should be "Elavon Request Sig.pdf"
When User Select "Direct Link" in Link Settings
And Select a template "1040 Engagement Joint (SAT)"
When User enter first signer details
|First Name	|Last Name	|Email Address			|
|One				|Test				|testOne@gmail.com	|
And Enter second signer details
|First Name	|Last Name	|Email Address						|
|two				|Test				|testOne(test)@gmail.com	|
And Click Prepare Request button
Then Signature Request Created
And Signer should be notified

@test3
Scenario: Open Signature Request from subtask Notify when viewed and completed toggle off
Given User is on Client Workspace "Paul Automation"
When User Open E-signature from subtask menu
Then A modal should be displayed with header message "Prepare document for e-signature"
And Workspace location should be "Paul Automation"
When User Enter in Link Settings
|Link Setting				|Question																									|Answer				|
|Question/Answer		|What is your social security number, without the dashes?	|123456789		|
And Select a template "1040 Engagement Joint (SAT)"
When User enter first signer details
|First Name	|Last Name	|Email Address			|
|One				|Test				|testOne@gmail.com	|
And Enter second signer details
|First Name	|Last Name	|Email Address						|
|two				|Test				|testOne(test)@gmail.com	|
And Click Prepare Request button
Then Signature Request Created
And Signer should be notified

@test4
Scenario: Request Signature for doxc file
Given User is on "Workspaces" page
When User search "420 consulting.docx"
And User Enter a client name in advance search "Franco Islaw"
And Select the expected file
Then Title page should be "File Preview"
When User Click Request Signature
Then Workspace location should be "Franco Islaw"
And File Name should be "420 consulting.docx"
When User Select "Direct Link" in Link Settings
And Select a template "1040 EFILES FED & CA Single"
When User enter first signer details
|First Name	|Last Name	|Email Address			|
|One				|Test				|testOne@gmail.com	|
And Click Prepare Request button
Then Signature Request Created
And Signer should be notified


@test5
Scenario: Request Signature Indiviual Authentication
Given User is on Client Workspace "Elavon"
When User Clicks a PDF file
When User Click Request Signature
Then Workspace location should be "Elavon"
When User Select "Individual Authentication" in Link Settings
And Select a template "VA-8879-2021-Joint"
When User enter first signer details
|First Name	|Last Name	|Email Address			|
|One				|Test				|testOne@gmail.com	|
And Selects a authentication
|Question																											|Answer				|
|What are the last 4 numbers of your Social Security Number?	|0000					|					
And Enter second signer details
|First Name	|Last Name	|Email Address						|
|two				|Test				|testOne(test)@gmail.com	|
And Selects a authentication
|Question											|Answer						|
|What is your favorite movie?	|Endgame					|			
And Click Prepare Request button
Then Signature Request Created
And Signer should be notified




