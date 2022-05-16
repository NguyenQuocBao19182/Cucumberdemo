package stepDefinitions;

import anhtester.common.helpers.ValidateUIHelper;
import anhtester.page.LoginPage;
import anhtester.page.TopPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    public WebDriver driver;
    public LoginPage loginPage;
    public TopPage topPage;

    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver = new BaseSetup().setupDriver("chrome");
        loginPage = new LoginPage(driver);
        topPage = new TopPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @When("Click on Login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.clickLogin();
    }

    @When("User can see the error message {string}")
    public void user_can_see_the_error_message(String string) {
        driver.getPageSource().contains(string);
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        topPage.verifyPageTitle(title);
    }

    @When("User launch Microsoft Edge browser")
    public void user_launch_microsoft_edge_browser() {
        driver = new BaseSetup().setupDriver("edge");
    }

    @Then("close browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
