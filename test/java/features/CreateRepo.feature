Feature: Create a new GitHub repository

  Scenario: User creates a new repository
    Given User sets up the API request
    When User sends a "POST" request to "/user/repos" with the following JSON:
    """
    {
      "name": "TestRepo",
      "description": "Repository created via API",
      "private": false
    }
    """
    Then The API response status should be 201
    And The response should contain "full_name" with "TestRepo"
