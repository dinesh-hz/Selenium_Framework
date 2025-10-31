@try
Feature: facebook web application new account create page

  Background: user should be on webpage

    Given user should be  in webpage


  Scenario: verify the add new user
    Given user should clcik the createnewaccound button
    When user should be fill the fome
    Then user clcik the login button
