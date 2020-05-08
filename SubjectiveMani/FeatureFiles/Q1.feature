Feature: Q1 Test

Scenario Outline: Register
Given I have url
When I enter the register <password>details<cpassword>
And I click the submit button
Then I able to see the successpage<password>
Examples:
|password|cpassword|
|success|success|
|failed|failed1|