package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TopPage {

    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    private By headerChannelList = By.xpath("//h2[contains(text(),'チャンネル')]");
    private String url = "/ekycs.jp";
    private By pageTitle_element = By.xpath("//span[contains(text(),'申込状況一覧')]");
    private By button_userManage = By.xpath("//span[contains(text(),'担当者管理')]");

    public TopPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
    }

    public void verifyPageTitle(String pageTitle) {
        validateHelper.verifyElementText(pageTitle_element, pageTitle);
        System.out.println("page cua top " + pageTitle_element);
    }
//    public CreateChannelPage openChannelList() throws InterruptedException {
//        validateHelper.waitForPageLoaded();
//        System.out.println("Title is " + validateHelper.getTitle());
//        Assert.assertTrue(validateHelper.verifyTitle(pageTitle), "Chua dung title");
//        Assert.assertTrue(validateHelper.verifyURL(url), "Khong phai channel list");
//        return new CreateChannelPage(driver);
//    }

}
