package stepDefinitions;

import anhtester.page.LoginPage;
import anhtester.page.TopPage;
import anhtester.page.UserManagePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {
    public WebDriver driver;
    public LoginPage loginPage;
    public TopPage topPage;
    public UserManagePage userManagePage;


    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        loginPage = new LoginPage();
//        topPage = new TopPage();
//        userManagePage = new UserManagePage();
        loginPage.setBrowser("chrome");
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        //driver.get(url);
        loginPage.accessURL(url);
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

//    @When("User can see the error message {string}")
//    public void user_can_see_the_error_message(String string) {
//        verifyErrorMessage(string);
//    }
//
//    @Then("Page title should be {string}")
//    public void page_title_should_be(String title) {
//        topPage.verifyPageTitle(title);
//    }
//
//    @When("User launch Microsoft Edge browser")
//    public void user_launch_microsoft_edge_browser() {
//        setBrowser("edge");
//        //driver = new BaseSetup().setupDriver("edge");
//    }
//
//    @Then("Click on 担当者管理:User Manage item on Left Menu")
//    public void click_on_担当者管理_user_manage_item_on_left_menu() {
//        topPage.clickUserManage();
//    }
//
//    @Then("Title of User Manage page is {string}")
//    public void title_of_user_manage_page_is(String string) {
//        userManagePage.checkHeaderUserManagePage(string);
//    }
//
//    @When("the user click on 新規アカウント登録:New account registration button")
//    public void the_user_click_on_新規アカウント登録_new_account_registration_button() {
//        userManagePage.clickCreateUser();
//    }
//
//    @Then("the Enter persional pop-up is displayed with title is {string}")
//    public void the_enter_persional_pop_up_is_displayed_with_title_is(String string) {
//        userManagePage.verifyCreatePopup(string);
//    }
//
//    @When("the user input {string} into userID textbox")
//    public void the_user_input_into_user_id_textbox(String string) {
//        userManagePage.setTextUserID(string);
//    }
//
//    @When("the user input {string} into Responsible person textbox")
//    public void the_user_input_into_responsible_person_textbox(String string) throws InterruptedException {
//        userManagePage.setTextResponsiblePersion(string);
//    }
//
//    @When("the user Click on 承認者:Operator radio button")
//    public void the_user_click_on_承認者_operator_radio_button() {
//        userManagePage.clickOperatorRole();
//    }
//
//    @When("the user Click on Branch dropdownlist")
//    public void the_user_click_on_branch_dropdownlist() {
//        userManagePage.clickDummyBankDropdownlist();
//    }
//
//    @When("the user Select Dummy Bank branch A")
//    public void the_user_select_dummy_bank_branch_a() {
//        userManagePage.selectDummyBankA();
//    }
//
//    @When("the user input {string} into department textbox")
//    public void the_user_input_into_department_textbox(String string) {
//        userManagePage.setDepartment(string);
//    }
//
//    @When("the user input {string} into email textbox")
//    public void the_user_input_into_email_textbox(String string) {
//        userManagePage.setEmail(string);
//    }
//
//    @When("the user input {string} into phone number textbox")
//    public void the_user_input_into_phone_number_textbox(String string) {
//        userManagePage.setPhoneNumber(string);
//    }
//
//    @When("the user click on アカウント登録:Register button")
//    public void the_user_click_on_アカウント登録_register_button() {
//        userManagePage.clickonSubmitButton();
//    }
//
//    @Then("the {string} pop-up is displayed")
//    public void the_pop_up_is_displayed(String string) {
//        userManagePage.verifyCreateSuccessPopup(string);
//    }
//
//    @Then("the new user with Responsible person {string} displayed on User list")
//    public void the_new_user_with_responsible_person_displayed_on_user_list(String string) throws InterruptedException {
//        Thread.sleep(5000);//sẽ tìm cách wait for element disappeared in this step
//        Assert.assertTrue(userManagePage.verifyUserListByResponsiblePersion(string));
//    }

    @Then("close browser")
    public void close_browser() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
        loginPage.quitBrowser();
    }
}
