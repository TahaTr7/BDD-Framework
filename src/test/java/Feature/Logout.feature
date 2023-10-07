
  Feature: SwagLab logout

    Scenario: Verify logout functionality
      Given User launched the browser
      And User navigates to "https://www.saucedemo.com/"
      And Enter valid credentials and click on login button
      Then User click top left nav bar and click on logout
      And User should return to login page
      And User close the browser