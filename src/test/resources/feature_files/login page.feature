#@try
Feature: login page


  Background: user can open browser to be in the web page
    Given user is on the login page


  Scenario Outline: verify login with a valid credentials
    Given user entre the valid "<username>" and "<password>"
    Then user click the login button
    And user should see homepage
    Then user should logout

    Examples:
      | username | password |
      | admin    | admin123 |
      | ADMIN    | admin123 |


  Scenario: verify login with an invalid credentials
    Given user entre the invalid username and password
    Then user click the login button
    And user should see error message "Invalid credentials"

  Scenario: verify login with an invalid username
    Given user entre the invalid username "Worrg"
    When user entre password
    Then user click the login button
    And user should see error message "Invalid credentials"

  Scenario: verify login with an invalid password
    Given user entre the username
    When user entre invalid password
    Then user click the login button
    And user should see error message "Invalid credentials"

  Scenario: verify login with empty box username and password
    Given user dont enter anything username and password
    Then user click the login button
    And user should see error message of username&password needs "Required"

  Scenario: verify login username with empty box
    Given user dont entre  enything username
    When user entre password
    Then user click the login button
    And user should see error message of username "Required"

  Scenario: verify login password with empty box
    Given user entre the username
    When user dont entre  enything password
    Then user click the login button
    And user should see error message of password "Required"

  Scenario: verify login password is masking while typing
    Given user entre on password box

  Scenario: verify Forgot Password Link page
    Given user click the Forgot Password link
    Then user should go Forgot Password page "Reset Password"


  Scenario: Verify login with lowercase username for casesenictive
    Given user entre the username "admin" and password "admin123"
    Then user click the login button
    And user should not go to the homepage


  Scenario: Verify login with uppercase username for  casesenictive
    Given user entre the username  and password
      | username | ADMIN    |
      | password | admin123 |
    Then user click the login button
    And user should not go to the homepage

  Scenario: verify Login button is  Disabled before entre credentials
    Given user does not entre anything
    Then user check on login button is disabled

  Scenario: verify after Login with a vaild credentials to redirect homepage
    Given user entre username and password vaild credentials
    When user click the login button
    Then user should go to the homepage

  Scenario: verify login button is enable after entre credentials
    Given user entre  username and password
    Then user  check on login button is enable

  Scenario Outline: verify login an invalid password in Multiple Failed Attempts
    Given user entres an valid username and invalid password "<password>"
    When user click the login button
    Then user should see an error message "Invalid credentials"

    Examples:
      | password |
      | 12345    |
      | 67890    |
      | 22031997 |
