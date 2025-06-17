@web @priority3
Feature: Login ke Demoblaze
  @positive
  Scenario: User can login to Homepage
    Given user open homepage Demoblaze
    When user click login button
    And user input username "finalprojectami" and password "finalprojectami"
    And user hit login button
    Then system direct to homepage

  @negative
  Scenario: Failed to login with invalid password
    Given user open homepage Demoblaze
    When user click login button
    And user input username "finalprojectami" and password "finalprojectami7"
    And user hit login button
    Then system show message "Wrong password."

  # @negative
  # Scenario: Failed to login with unregister username
    #Given user open homepage Demoblaze
    #When user click login button
    #And user input username "boroboroo" and password "finalprojectami7"
    #And user hit login button
    #Then system show message "User does not exist."