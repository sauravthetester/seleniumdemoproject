Feature: GitHub site - GitHub Copilot

  Scenario Outline: Verify Sign In button available
    Given Go to Github
    And Click on Try Github Copilot
    Then Click on <option>
    And Verify Sign In button available
    Examples:
      | option  								|
      | Try Github Copilot Pro	|
      | Sign In 								|
