Feature: Create User

  Scenario: User is able to create Operator account

    Given User launch Chrome browser
    When User opens URL "http://console-dev.ekycs.jp/"
    And User enters Email as "12312312321" and Password as "Fintech@123"
    And Click on Login button
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And User enters Email as "mti1_admin" and Password as "Fintech@123"
    And Click on Login button
    Then Page title should be "申込状況一覧"
    And Click on 担当者管理:User Manage item on Left Menu
    Then Title of User Manage page is "担当者管理"
    When the user click on 新規アカウント登録:New account registration button
    Then the Enter persional pop-up is displayed with title is "登録する担当者情報を入力してください"
    When the user input "baoauto2" into userID textbox
    And the user input "登録する登録する" into Responsible person textbox
    And the user Click on 承認者:Operator radio button
    And the user Click on Branch dropdownlist
    And the user Select Dummy Bank branch A
    And the user input "登録する登" into department textbox
    And the user input "baonq@mti-tech.vn" into email textbox
    And the user input "1234567891" into phone number textbox
    And the user click on アカウント登録:Register button
    Then the "登録しました" pop-up is displayed
    And the new user with Responsible person "登録する登録する" displayed on User list
    And close browser