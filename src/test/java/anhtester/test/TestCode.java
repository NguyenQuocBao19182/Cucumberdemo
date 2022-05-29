package anhtester.test;

import anhtester.page.LoginPage;
import anhtester.page.TopPage;
import anhtester.page.UserManagePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import stepDefinitions.BaseSetup;
import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestCode {
    private WebDriver driver;
    public LoginPage loginPage;
    public TopPage topPage;
    public UserManagePage userManagePage;
    private ValidateUIHelper validateUIHelper;
    private By buttonSubmit = By.id("next");
    private By button_userManage = By.xpath("//*[contains(text(),'担当者管理')]");
    private By button_createUser = By.xpath("//*[contains(text(),'新規アカウント登録')]");
    private By title_createUserPopup = By.xpath("//*[contains(text(),'登録する担当者情報を入力してください')]");
    private By radiobutton_operator = By.xpath("//label[contains(text(),'一般')]");
    private By dropdownlist_dummybank = By.xpath("(//div[contains(@class,'v-select__selections')])[2]");
    private By dropdownlist_role = By.xpath("//div[@id='list-']");
    private By button_dummyC = By.xpath("//div[contains(text(),'Dummy bank branch C')]");
    private By button_SubmitCreateUser = By.xpath("//button[@class='font-weight-bold ekyc-btn v-btn v-btn--outlined theme--light v-size--default prime large']//span[@class='v-btn__content'][contains(text(),'アカウント登録')]");

    @BeforeClass
    public void setupDriver() {
        driver = new BaseSetup().setupDriver("chrome");
        validateUIHelper = new ValidateUIHelper(driver);
        loginPage = new LoginPage(driver);
        topPage = new TopPage(driver);
        userManagePage = new UserManagePage(driver);
    }

    @Test
    public void loginPage() throws InterruptedException {
        driver.get("http://console-dev.ekycs.jp/");
        loginPage.setEmail("mti1_admin");
        loginPage.setPassword("Fintech@123");
        validateUIHelper.clickElement(buttonSubmit);
        validateUIHelper.waitForPageLoaded();
        validateUIHelper.clickElement(button_userManage);
//        validateUIHelper.clickElement(button_createUser);
//        Assert.assertEquals(title_createUserPopup.findElement(driver).getText(), "登録する担当者情報を入力してください");
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.TAB).build().perform();
//        action.sendKeys("AutoGenerally");
//        action.sendKeys(Keys.TAB).build().perform();
//        action.sendKeys("AutoResponsiblePersion").perform();
//        validateUIHelper.clickElement(radiobutton_operator);
//        validateUIHelper.clickElement(dropdownlist_dummybank);
////        action.sendKeys(Keys.DOWN).build().perform();
////        Thread.sleep(1000);
////        action.sendKeys(Keys.ENTER).build().perform();
////        Thread.sleep(1000);
//        validateUIHelper.clickElement(button_dummyC);
//        action.sendKeys(Keys.TAB).build().perform();
//        action.sendKeys("QA").perform();
//        action.sendKeys(Keys.TAB).build().perform();
//        action.sendKeys("baonq@mti-tech.vn").perform();
//        action.sendKeys(Keys.TAB).build().perform();
//        action.sendKeys("0932530922").perform();
//        validateUIHelper.clickElement(button_SubmitCreateUser);
        List<WebElement> list_User = driver.findElements(By.xpath("//table/tbody/tr"));
        WebElement colum_Responsible = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        //System.out.println("User capacity is " + list_User.size());
        //System.out.println("Responsible person " + colum_Responsible.getText());
        for (int i = 1; i <= list_User.size(); i++) {
            By element = By.xpath("//tbody/tr[" + i + "]/td[" + 1 + "]");
            WebElement item_User = driver.findElement(element);
            validateUIHelper.scrolltoElement(element);
            if (item_User.getText().contains("登録する登録する") == true) {
                System.out.println("Co " + item_User.getText() + " User vua tao");
                break;
            }
            System.out.println("Khong co User vua tao");
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
