
Feature: Checkout product from cart

  Scenario: Verify the checkout functionality
    Given User launched the browser
    And User navigates to "https://www.saucedemo.com/"
    When Enter valid credentials and click on login button
    And User click on add to cart button
    And User navigates to Your Cart page
    And User Click on checkout button
    And User provided the checkout information
    And User click on Finish
    Then User should receive order confirmation message
    And User close the browser
