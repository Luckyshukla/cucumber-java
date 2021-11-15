Feature: career portal Login
  @RegressionTest
  Scenario Outline: Login to xenonstack with Multiple parameters
    Given I launch Chrome browser
    When I open xenonstack career homepage
    And User enters "<username>" and "<password>"
    And click on login button
    And Verify Is credentials are valid or not
    And Check the progress
    Then Process completed

    Examples: 
      | username                   | password  |
      | luckyshuklakunda@gmail.com | Lucky@123 |

  @FunctionTests
  Scenario: Successful Login
    Given This is a blank test
