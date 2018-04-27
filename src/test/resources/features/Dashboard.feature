@dashboard

Feature: Validate AirPR dashboard elements

  Scenario: A user logs in, he sees Dashboard screen as a default screen
    Given User logs in to "Analyst" UI as a "profile" user
    Then user is shown Dashboard screen by default