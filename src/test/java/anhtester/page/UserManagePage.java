package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class UserManagePage {
    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    Actions action;
    private By header_UserManage = By.xpath("//h1[contains(text(),'担当者管理')]");
    private By button_createUser = By.xpath("//*[contains(text(),'新規アカウント登録')]");
    private By title_createUserPopup = By.xpath("//*[contains(text(),'登録する担当者情報を入力してください')]");
    private By radiobutton_operator = By.xpath("//label[contains(text(),'一般')]");
    private By dropdownlist_dummybank = By.xpath("(//div[contains(@class,'v-select__selections')])[2]");
    private By dropdownlist_role = By.xpath("//div[@id='list-']");
    private By button_dummyC = By.xpath("//div[contains(text(),'Dummy bank branch C')]");
    private By button_SubmitCreateUser = By.xpath("//button[@class='font-weight-bold ekyc-btn v-btn v-btn--outlined theme--light v-size--default prime large']//span[@class='v-btn__content'][contains(text(),'アカウント登録')]");

    public UserManagePage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
        action = new Actions(driver);
    }

    public void checkHeaderUserManagePage(String headerUserManagePage) {
        validateHelper.verifyElementText(header_UserManage, headerUserManagePage);
    }

    public void clickCreateUser() {
        validateHelper.clickElement(button_createUser);
    }

    public void verifyCreatePopup(String titlePopup) {
        validateHelper.verifyElementText(title_createUserPopup, titlePopup);
    }

    public void setTextUserID(String userID) {
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(userID);
    }

    public void setTextResponsiblePersion(String responsiblePersion) throws InterruptedException {
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(responsiblePersion).perform();
    }

    public void clickOperatorRole() {
        validateHelper.clickElement(radiobutton_operator);
    }

    public void clickDummyBankDropdownlist() {
        validateHelper.clickElement(dropdownlist_dummybank);
    }

    public void selectDummyBankA() {
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void selectDummyBankC() {
        validateHelper.clickElement(button_dummyC);
    }

    public void setDepartment(String department) {
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(department).perform();
    }

    public void setEmail(String email) {
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(email).perform();
    }

    public void setPhoneNumber(String phoneNumber) {
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(phoneNumber).perform();
    }

    public void clickonSubmitButton() {
        validateHelper.clickElement(button_SubmitCreateUser);
    }

    public void verifyCreateSuccessPopup(String message) {
        validateHelper.verifyPageSource(message);
    }

    public boolean verifyUserListByResponsiblePersion(String responsiblePersion) {
        Boolean verify = null;
        List<WebElement> list_User = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i <= list_User.size(); i++) {
            By element = By.xpath("//tbody/tr[" + i + "]/td[" + 1 + "]");
            WebElement item_User = driver.findElement(element);
            validateHelper.scrolltoElement(element);
            if (item_User.getText().equals(responsiblePersion)) {
                verify = true;
                break;
            }
            verify = false;
        }
        return verify;
    }
}
