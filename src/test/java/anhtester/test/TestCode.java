package anhtester.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepDefinitions.BaseSetup;
import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestCode extends BaseSetup {
    private ValidateUIHelper validateUIHelper;
    private By buttonSubmit = By.id("next");


    private By button_createUser = By.xpath("//*[contains(text(),'新規アカウント登録')]");
    private By title_createUserPopup = By.xpath("//*[contains(text(),'登録する担当者情報を入力してください')]");
    private By button_dummyC = By.xpath("//div[contains(text(),'Dummy bank branch C')]");
    private By button_SubmitCreateUser = By.xpath("//button[@class='font-weight-bold ekyc-btn v-btn v-btn--outlined theme--light v-size--default prime large']//span[@class='v-btn__content'][contains(text(),'アカウント登録')]");
    private By textboxUsername = By.cssSelector("input[id='UserId']");
    private By textboxPassword = By.id("password");
    private String responsiblepersion = "baoauto";

    //private By btnSubmit = By.xpath("//button[@class='font-weight-bold ekyc-btn v-btn v-btn--outlined theme--light v-size--default prime large']//span[@class='v-btn__content'][contains(text(),'アカウント登録')]");

    @BeforeClass
    public void initDriver() {
        setupDriver("chrome");
        validateUIHelper = new ValidateUIHelper(driver);

    }

    @Test(priority = 0)
    public void loginPage() throws InterruptedException {
        driver.get("http://console-dev.ekycs.jp/");
        //validateUIHelper = new ValidateUIHelper(driver);
        validateUIHelper.setTextbyBy(textboxUsername, "mti1_admin");
        validateUIHelper.setTextbyBy(textboxPassword, "Fintech@123");
        validateUIHelper.ClickElementbyBy(buttonSubmit);
        validateUIHelper.waitForPageLoaded();
        List<WebElement> LeftSideButton = driver.findElements(By.cssSelector("span.flex-grow-1"));
        for (int i = 0; i <= LeftSideButton.size(); i++) {
            if (LeftSideButton.get(i).getText().equals("担当者管理")) {
                validateUIHelper.ClickElementbyWebElemt(LeftSideButton.get(i));
                break;
            }

        }
//        WebElement button_userManage = LeftSideButton.get(4);
//        validateUIHelper.findByClickElement(button_userManage);
        validateUIHelper.ClickElementbyBy(button_createUser);
    }

    @Test(priority = 1)
    public void createUser() throws InterruptedException {
        Assert.assertEquals(title_createUserPopup.findElement(driver).getText(), "登録する担当者情報を入力してください");
        WebElement txtbox_userID = validateUIHelper.GetElementWithLabelbyXpath("ユーザーID");

        validateUIHelper.setTextbyWebElement(txtbox_userID, "baoauto5");

        WebElement textbox_responPersion = validateUIHelper.GetElementWithLabelbyXpath("担当者名");
        validateUIHelper.setTextbyWebElement(textbox_responPersion, responsiblepersion);

        List<WebElement> dropdownBranch = driver.findElements(By.className("v-input__append-inner"));
        dropdownBranch.get(1).click();

        List<WebElement> listBranch = driver.findElements(By.className("v-list-item__title"));
        listBranch.get(3).click();

        WebElement textbox_branch = validateUIHelper.GetElementWithLabelbyXpath("所属部署");
        validateUIHelper.setTextbyWebElement(textbox_branch, "auto");

        WebElement textbox_email = validateUIHelper.GetElementWithLabelbyXpath("メールアドレス");
        validateUIHelper.setTextbyWebElement(textbox_email, "baonq@mti-tech.vn");

        WebElement textbox_phoneNumber = validateUIHelper.GetElementWithLabelbyXpath("電話番号");
        validateUIHelper.setTextbyWebElement(textbox_phoneNumber, "0932530922");

        List<WebElement> listbtnSubmit = driver.findElements(By.cssSelector("span.v-btn__content"));
        validateUIHelper.ClickElementbyWebElemt(listbtnSubmit.get(19));
        //WebElement element = driver.findElement(btnSubmit);
        //validateUIHelper.findByClickElement(element);
    }

    @Test(priority = 2)
    public void checkUser() {
        List<WebElement> list_User = driver.findElements(By.xpath("//table/tbody/tr"));
        WebElement colum_Responsible = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        //System.out.println("User capacity is " + list_User.size());
        //System.out.println("Responsible person " + colum_Responsible.getText());
        for (int i = 1; i <= list_User.size(); i++) {
            By element = By.xpath("//tbody/tr[" + i + "]/td[" + 1 + "]");
            WebElement item_User = driver.findElement(element);
            validateUIHelper.scrolltoElement(element);
            if (item_User.getText().contains(responsiblepersion) == true) {
                System.out.println("Co " + item_User.getText() + " User vua tao");
                break;
            }
            System.out.println("Khong co User vua tao");
        }
    }


    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
