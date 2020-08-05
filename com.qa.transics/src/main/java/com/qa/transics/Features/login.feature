Feature: Login My Transics

Scenario Outline: Login with valid credentials

Given User is on My Transics login page
And Tilte of the page is myTransics
When User enters "<username>" and "<password>"
And User clicks on Login button
Then User navigates to tiles page
Then Close the browser

Examples:
	| username 					| password  |
	| iamhst@gmail.com  | @@@....... |
	| iamhst@gmail.com  | @@@. |
