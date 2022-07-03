Feature: Login

  Scenario: User can login with valid data
    Given User launch Chrome browser
    When User opens URL "http://console-dev.ekycs.jp/"
    And User enters Email as "mti1_admin" and Password as "Fintech@123"
    And Click on Login button
    Then Page title should be "申込状況一覧"
    And close browser
#    Examples:
#      | email           | password    |
#      | mti1_admin      | Fintech@123 |
#      | mti1_baomanager | Fintech@123 |

#  Scenario Outline: User can not login with invalid data
#    Given User launch Chrome browser
#    When User opens URL "http://console-dev.ekycs.jp/"
#    And User enters Email as "<email>" and Password as "<password>"
#    And Click on Login button
#    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
#    And close browser
#    Examples:
#      | email        | password    |
#      | mti1_admin23 | Fintech@123 |
#      | mti1_admin32 | Fintech@123 |