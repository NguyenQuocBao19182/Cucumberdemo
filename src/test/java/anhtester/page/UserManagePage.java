package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagePage {
    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    private By header_UserManage = By.xpath("//h1[contains(text(),'担当者管理')]");

    public UserManagePage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
    }

    public void checkHeaderUserManagePage(String headerUserManagePage) {
        validateHelper.verifyElementText(header_UserManage, headerUserManagePage);
    }

}
