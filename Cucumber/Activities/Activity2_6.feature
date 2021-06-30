@activity2_6
Feature: Login Test

Scenario Outline: Testing Login with Examples
    Given User is on Login page
    When User enters "<usernames>" and "<passwords>"
    Then Read the page title and confirmation message
    And Close the Browser
Examples: 
| usernames |  passwords  |
|  admin   |   password |
| adminUser | password |  