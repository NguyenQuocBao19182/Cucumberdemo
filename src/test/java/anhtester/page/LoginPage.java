package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    private By headerLogin = By.xpath("//div[contains(text(),'管理コンソール')]");
    private By textboxUsername = By.id("UserId");
    private By textboxPassword = By.id("password");
    private By buttonSubmit = By.id("next");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
    }


    //Khi chạy xong trang login thì trả về sự khởi tạo của trang Channel List luôn
//    public TopPage login(String username, String password) {
//        Assert.assertTrue(validateHelper.verifyElementText(headerLogin, textHeader), "Khong phai man hinh Login");
//        validateHelper.setText(textboxUsername, username);
//        validateHelper.setText(textboxPassword, password);
//        validateHelper.clickElement(buttonSubmit);
//        validateHelper.waitForPageLoaded();
//        return new TopPage(driver);
//    }

    public void setEmail(String email) {
        validateHelper.setText(textboxUsername, email);
    }

    public void setPassword(String password) {
        validateHelper.setText(textboxPassword, password);
    }

    public void clickLogin() {
        validateHelper.clickElement(buttonSubmit);
    }

    public void verifyErrorMessage(String message_error) {
        validateHelper.verifyPageSource(message_error);
    }
}
