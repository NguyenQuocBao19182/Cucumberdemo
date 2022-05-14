Feature: Login

  Scenario: Login Successful with Valid data
    Given User launch Chrome browser
    When User opens URL "https://prod-dev.svcall.jp/"
    And User enters Email as "nguyen.quoc.bao@sun-asterisk.com" and Password as "123@123a"
    And Click on Login button
    Then Page title should be "prrrr 管理"
    And close browser

