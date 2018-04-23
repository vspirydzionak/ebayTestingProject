Meta:

Narrative:
As a user
I want to go register on "https://www.ebay.com"

Scenario: testing register data
Given user goes to start page 'https://www.ebay.com'
When user clicks register link
And user goes to register page
And user enters first name
And user enters last name
And user enters email
And user enters password
And user clicks submit button
Then system shows username 'Vasili'
