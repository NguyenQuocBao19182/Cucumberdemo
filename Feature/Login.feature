Feature: Login

  Scenario: Login with Chrome
    Given User launch Chrome browser
    When User opens URL "http://console-dev.ekycs.jp/"
    And User enters Email as "12312312321" and Password as "Fintech@123"
    And Click on Login button
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And User enters Email as "mti1_admin" and Password as "Fintech@123"
    And Click on Login button
    Then Page title should be "申込状況一覧"
    And Click on 担当者管理/User Manage item on Left Menu
    Then Title of User Manage page is "担当者管理"
    And close browser


#  Scenario: Login Successful with Valid data Edge
#    When User launch Microsoft Edge browser
#    And User opens URL "https://prod-dev.svcall.jp/"
#    And User enters Email as "nguyen.quoc.bao@sun-asterisk.com" and Password as "123@123a"
#    And Click on Login button
#    Then Page title should be "prrrr 管理"
#    And close browser

