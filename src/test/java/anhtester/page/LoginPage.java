package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinitions.BaseSetup;

public class LoginPage extends BaseSetup {

    private ValidateUIHelper validateHelper;
    private By headerLogin = By.xpath("//div[contains(text(),'管理コンソール')]");
    private By textboxUsername = By.id("UserId");
    private By textboxPassword = By.id("password");
    private By buttonSubmit = By.id("next");

    //Khi chạy xong trang login thì trả về sự khởi tạo của trang Channel List luôn
//    public TopPage login(String username, String password) {
//        Assert.assertTrue(validateHelper.verifyElementText(headerLogin, textHeader), "Khong phai man hinh Login");
//        validateHelper.setText(textboxUsername, username);
//        validateHelper.setText(textboxPassword, password);
//        validateHelper.clickElement(buttonSubmit);
//        validateHelper.waitForPageLoaded();
//        return new TopPage(driver);
//    }
    public void setBrowser(String browser) {
        setupDriver(browser);
        validateHelper = new ValidateUIHelper(driver);
    }

    public void accessURL(String url) {
        driver.get(url);
    }

    public void setEmail(String email) {
        validateHelper.setTextbyBy(textboxUsername, email);
    }

    public void setPassword(String password) {
        validateHelper.setTextbyBy(textboxPassword, password);
    }

    public void clickLogin() {
        validateHelper.ClickElementbyBy(buttonSubmit);
    }

    public void verifyErrorMessage(String message_error) {
        validateHelper.verifyPageSource(message_error);
    }

    public void quitBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
