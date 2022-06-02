Feature: Login

  Scenario Outline: User can login with valid data
    Given User launch Chrome browser
    When User opens URL "http://console-dev.ekycs.jp/"
    And User enters Email as "<email>" and Password as "<password>"
    When User opens URL ""
    And User enters Email as "12312312321" and Password as "Fintech@123"
    And Click on Login button
    Then Page title should be "申込状況一覧"
    And close browser
    Examples:
      | email | password |
      | mti1_admin | Fintech@123 |
      | mti1_baomanager | Fintech@123 |

  Scenario Outline: User can not login with invalid data
    Given User launch Chrome browser
    When User opens URL "http://console-dev.ekycs.jp/"
    And User enters Email as "<email>" and Password as "<password>"
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And User enters Email as "" and Password as ""
    And Click on Login button
    When User enters Email as "<email1>" and Password as "<password1>"
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And close browser
    Examples:
      | email | password | email1 | password1 |
      | email | password | email1 | password1 |

