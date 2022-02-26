Feature: Users should be able to login
  @login




  Scenario Outline:Login with <userType>
    Given the user is on the login page
    When the user logs in using "<userType>" and "<password>" in following credentials

    Examples:
      | userType  | password      | message                          |
      | username  | password      | Zero - Account Summary           |
      | wronguser | password      | Login and/or password are wrong. |
      | username  | wrongpassword | Login and/or password are wrong. |
      |           | password      | Login and/or password are wrong. |
      | username  |               | Login and/or password are wrong. |
