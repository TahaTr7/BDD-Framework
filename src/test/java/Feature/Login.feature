
Feature: SwagLab login

  Scenario: After successful login verify home page logo
    Given User launched the browser
    When User navigates to "https://www.saucedemo.com/"
    And Enter valid credentials and click on login button
    Then User should login
    And User close the browser

  Scenario:  Verify Validation Message When providing invalid credentials
    Given User launched the browser
    When User navigates to "https://www.saucedemo.com/"
    And Enter invalid credentials and click on login button
    Then User should get validation message
    And User close the browser
