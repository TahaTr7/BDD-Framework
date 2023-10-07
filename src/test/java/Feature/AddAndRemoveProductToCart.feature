
Feature: Add and Remove product to Cart

  Scenario: Add product to cart
    Given User launched the browser
    And User navigates to "https://www.saucedemo.com/"
    And Enter valid credentials and click on login button
    When User click on add to cart button
    And User navigates to Your Cart page
    Then Product should be added to cart
    And User remove the product from cart
    And User close the browser
