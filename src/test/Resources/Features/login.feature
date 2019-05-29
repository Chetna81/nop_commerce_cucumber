@login

Feature: LoginPage

  Scenario Outline: user should not be able to login with invalid credential
    Given user is on Login page
    When user enters invalid "<Email>" or "<Password>"
    And user click on login btn
    Then user should able to see the "<Error message>"

    Examples:
      | Email                       | Password | Error message                                                                             |
      | krishsuvagiya13@yahoo.com   | krish123 | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      | krishsuvagiya123@yahoo.com  | krish12  | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      | krishsuvagiya1@yahoo.com    |          | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      |                             | krish123 | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      | krishsuvagiya123@yahoo.com  |          | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      |                             | krish12  | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      | krishsuvagiya13@yahoo.com   |          | Login was unsuccessful. Please correct the errors and try again.No customer account found |
      | krishsuvagiya1234@yahoo.com | krish123 | Login was unsuccessful. Please correct the errors and try again.No customer account found |
























