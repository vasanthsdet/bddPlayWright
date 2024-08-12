Feature: Gmail Login

  Scenario: Invalid login
    Given I am on the Gmail login page
    When I enter my email "veda.dama2019@gmail.com"
    And I enter my password "test"
    Then Validate password wrong message
