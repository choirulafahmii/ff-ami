Feature: Register Account in Demoblaze
  As new user
  I want register account in Demoblaze
  So I can login and shopping in this site

  Scenario Outline: Register account on Demoblaze
    Given user open homepage Demoblaze
    When user click Sign up menu
    And user input username "<type>"
    And user input password "<password>"
    And user click Sign up button
    Then system show message "<expectedMessage>"

    Examples:
      | type     | password    | expectedMessage              |
      | new   | ggmu1      | Sign up successful.          |
      | exists  | password123 | This user already exist.     |
