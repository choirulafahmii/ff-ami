  Feature: API Testing for DummyAPI.io

  @api
  Scenario: Create a new user
    Given I have user details with first name "fahmi", last name "ami", and a unique email
    When I send a request to create the user
    Then the user should be created successfully

  @api
  Scenario: Get user by ID
    Given I have the saved user ID
    When I send a GET request to "/user/{id}"
    Then the response status should be 200
    And the response should contain the user details

  @api
  Scenario: Update user details
    Given I have the saved user ID
    And I have updated user details with name "Mobi updated" and email "mobi.updated@example.com"
    When I send a PUT request to "/user/{id}"
    Then the response status should be 200
    And the response should contain the updated details

  @api
  Scenario: Delete user
    Given I have the saved user ID
    When I send a DELETE request to "/user/{id}"
    Then the response status should be 200
    And the user should no longer exist