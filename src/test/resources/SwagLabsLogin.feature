@Sanity
Feature: User login functionality
  Background:
    Given I am on the Swag Labs login page

@PositiveScenarios
Scenario Outline: Successful login
  When I enter the credentials <username> and <password>
  And I click on the Login button
  Then I should be redirected to the Products page
  And I should check if inventory items and images match <should_match>

Examples:
  | username                | password     | should_match |
  | standard_user           | secret_sauce | true         |
  | problem_user            | secret_sauce | false        |
  | performance_glitch_user | secret_sauce | true         |

@NegativeScenarios
  Scenario Outline: Unsuccessful login
    When I enter the credentials <username> and <password>
    And I click on the Login button
    Then I should see an error message <error_message>

    Examples:
      | username            | password        | error_message                                                             |
      | locked_out_user     | secret_sauce    | Epic sadface: Sorry, this user has been locked out.                       |
      | incorrect_user      | secret_sauce    | Epic sadface: Username and password do not match any user in this service |
      | standard_user       | wrong_password  | Epic sadface: Username and password do not match any user in this service |
