Feature: Register Account in Demoblaze
  As new user
  I want register account in Demoblaze
  So I can login and shopping in this site

  Scenario Outline: Register account on Demoblaze
    Given user open homepage Demoblaze
    When user click Sign up menu
    And user input username "<username>"
    And user input password "<password>"
    And user click Sign up button
    Then system show message "<expectedMessage>"

    Examples:
      | username | password    | expectedMessage              |
      | ggmu3    | ggmu1       | Sign up successful.          |
      | user123  | password123 | This user already exist.     |
