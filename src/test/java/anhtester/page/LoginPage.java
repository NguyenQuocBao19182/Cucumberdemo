package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    private String textHeader = "Welcome";
    private By headerLogin = By.xpath("//h1[contains(text(),'Welcome')]");
    private By textboxUsername = By.xpath("//input[@id='username']");
    private By textboxPassword = By.xpath("//input[@id='password']");
    private By buttonSubmit = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
    }


    //Khi chạy xong trang login thì trả về sự khởi tạo của trang Channel List luôn
    public ChannelListPage login(String username, String password) {
        Assert.assertTrue(validateHelper.verifyElementText(headerLogin, textHeader), "Khong phai man hinh Login");
        validateHelper.setText(textboxUsername, username);
        validateHelper.setText(textboxPassword, password);
        validateHelper.clickElement(buttonSubmit);
        validateHelper.waitForPageLoaded();
        return new ChannelListPage(driver);
    }

    public void setEmail(String email) {
        validateHelper.setText(textboxUsername, email);
    }

    public void setPassword(String password) {
        validateHelper.setText(textboxPassword, password);
    }

    public void clickLogin() {
        validateHelper.clickElement(buttonSubmit);
    }

}
