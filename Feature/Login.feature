Feature: Login

  Scenario: User can create Operator account
    Given User launch Chrome browser
    When User opens URL ""
    And User enters Email as "12312312321" and Password as "Fintech@123"
    And Click on Login button
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And User enters Email as "" and Password as ""
    And Click on Login button
    Then Page title should be "申込状況一覧"
    And close browser
