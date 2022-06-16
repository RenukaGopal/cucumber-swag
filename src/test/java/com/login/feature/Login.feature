Feature: Swaglabs login fuctionality in web application
Scenario: Login fuctionality of the application
   Given user launches swag "https://www.saucedemo.com/" application
   When user enter the user name in user textbox
   When user enter the password in pass textbox
   And user clicks the login button
   Then user verifies the product homepage
  