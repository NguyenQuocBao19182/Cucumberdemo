package stepDefinitions;

import anhtester.common.helpers.ValidateUIHelper;
import anhtester.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    public WebDriver driver;
    public LoginPage loginPage;
    public BaseSetup baseSetup;
    public ValidateUIHelper validateUIHelper;

    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver = new BaseSetup().setupDriver("chrome");
        loginPage = new LoginPage(driver);
        validateUIHelper = new ValidateUIHelper(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Wrong email or password")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(validateUIHelper.verifyTitle(title), "Chua dung title");
        }
    }

    @Then("close browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
