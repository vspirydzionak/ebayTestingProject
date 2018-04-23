Meta:

Narrative:
As a user
I want to try to register on "https://www.ebay.com"

Scenario: try to register with no input filled
Given user goes to start page 'https://www.ebay.com'
When user clicks register link
And user goes to register page
And user clicks first name input
And user clicks last name input
And user clicks password input
Then submit button disabled
Then error messages appear

Scenario: try to register with only first name
Given user goes to start page 'https://www.ebay.com'
When user clicks register link
And user goes to register page
And user enters first name
Then submit button disabled

Scenario: try to register with only last name
Given user goes to start page 'https://www.ebay.com'
When user clicks register link
And user goes to register page
And user enters last name
Then submit button disabled

Scenario: try to register with only password
Given user goes to start page 'https://www.ebay.com'
When user clicks register link
And user goes to register page
And user enters password
Then submit button disabled

