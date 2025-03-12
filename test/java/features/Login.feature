Feature: GitHub Login

  Scenario: Successful Login to GitHub
    Given User is on the GitHub login page
    When User enters valid credentials
    Then User should be logged in successfully
