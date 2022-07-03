package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stepDefinitions.BaseSetup;

public class TopPage extends BaseSetup {
    private ValidateUIHelper validateHelper;
    private String url = "/ekycs.jp";
    private By pageTitle_element = By.xpath("//span[contains(text(),'申込状況一覧')]");
    private By button_processing = By.xpath("//div[contains(text(),'処理中')]");
    private By button_userManage = By.xpath("//span[contains(text(),'担当者管理')]");

    public TopPage() {
        validateHelper = new ValidateUIHelper(driver);
    }

    public void verifyPageTitle(String pageTitle) throws InterruptedException {
        validateHelper.waitForPageLoaded();
        validateHelper.verifyElementTextbyBy(pageTitle_element, pageTitle);
    }

    public void clickUserManage() {
        validateHelper.ClickElementbyBy(button_userManage);
    }

//    public CreateChannelPage openChannelList() throws InterruptedException {
//        validateHelper.waitForPageLoaded();
//        System.out.println("Title is " + validateHelper.getTitle());
//        Assert.assertTrue(validateHelper.verifyTitle(pageTitle), "Chua dung title");
//        Assert.assertTrue(validateHelper.verifyURL(url), "Khong phai channel list");
//        return new CreateChannelPage(driver);
//    }


}
