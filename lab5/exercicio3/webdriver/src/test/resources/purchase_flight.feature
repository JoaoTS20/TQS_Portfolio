Feature: Purchase

  Scenario: Seek for Selenium-Jupiter documentation
    When I navigate to "https://blazedemo.com/"
    And I choose "Portland" as the departure city
    And I choose "Berlin" as the destination city
    And I click in Find flights
    And I choose the 3 th flight
    And I submit the form to purchase the flight
    Then Then the page title should start with "BlazeDemo Confirmation"