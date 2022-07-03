package stepDefinitions;

import anhtester.page.TopPage;
import io.cucumber.java.en.Then;

public class TopStepDef{
    private TopPage topPage;

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        topPage=new TopPage();
        topPage.verifyPageTitle(title);
    }


    @Then("Click on 担当者管理:User Manage item on Left Menu")
    public void click_on_担当者管理_user_manage_item_on_left_menu() {
        topPage.clickUserManage();
    }
}
