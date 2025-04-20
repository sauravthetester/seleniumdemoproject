Feature: GitHub site - GitHub Copilot

  Scenario: Verify Github copilot options for subscription
    Given Go to Github
    And Click on Try Github Copilot
    Then Verify Get started for free option available
    And Verify See plans and pricing option available

  Scenario Outline: Verify Sign In button available
    Given Go to Github
    And Click on Try Github Copilot
    Then Verify Get started for free option available
    And Verify See plans and pricing option available
    Then Click on <option>
    And Verify Sign In button available
    Examples:
      | option  		|
      | Get started |
      | Sign In 		|
