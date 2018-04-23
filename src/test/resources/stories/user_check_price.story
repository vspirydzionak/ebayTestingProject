Meta:

Narrative:
As a user I want to go to "ebay.com"
Enter book title and press enter
So that I can verify the first found price

Scenario: verifying the price
Given user goes to start page 'https://www.ebay.com'
When user selects books category
And user search 'Lord of the ring'
Then the first price is higher than 5 USD