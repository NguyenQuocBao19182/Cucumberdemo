Feature: Create User

  Scenario Outline: User is able to create Operator account

    Given User launch Chrome browser
    When User opens URL "<url>"
    And User enters Email as "<invalid_username>" and Password as "<invalid_password>"
    And Click on Login button
    And User can see the error message "ログインできませんでした。入力したログインIDまたはパスワードが正しくないか、アカウントが無効です。"
    And User enters Email as "<valid_username>" and Password as "<valid_password>"
    And Click on Login button
    And Page title should be "申込状況一覧"
    And Click on 担当者管理:User Manage item on Left Menu
    And Title of User Manage page is "担当者管理"
    And the user click on 新規アカウント登録:New account registration button
    And the Enter persional pop-up is displayed with title is "登録する担当者情報を入力してください"
    And the user input "<userID>" into userID textbox
    And the user input "<responsible_person>" into Responsible person textbox
    And the user Click on 承認者:Operator radio button
    And the user Click on Branch dropdownlist
    And the user Select Dummy Bank branch A
    And the user input "<department>" into department textbox
    And the user input "<email>" into email textbox
    And the user input "<phone_number>" into phone number textbox
    And the user click on アカウント登録:Register button
    Then the "登録しました" pop-up is displayed
    And the new user with Responsible person "登録する登録する" displayed on User list
    And close browser
    Examples:
      | url                          | invalid_username | invalid_password | valid_username | valid_password | userID      | responsible_person | department | email             | phone_number |
      | http://console-dev.ekycs.jp/ | invalidusername  | invalidpassword  | mti1_admin     | Fintech@123    | baoautotest | responsible_person | department | baonq@mti-tech.vn | 0932530922   |