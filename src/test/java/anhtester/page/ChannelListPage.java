package anhtester.page;

import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChannelListPage {

    private WebDriver driver;
    private ValidateUIHelper validateHelper;
    private By headerChannelList = By.xpath("//h2[contains(text(),'チャンネル')]");
    private String url = "/channel";
    private String pageTitle = "prrrr 管理";

    public ChannelListPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateUIHelper(driver);
    }

    public CreateChannelPage openChannelList() throws InterruptedException {
        validateHelper.waitForPageLoaded();
        System.out.println("Title is " + validateHelper.getTitle());
        Assert.assertTrue(validateHelper.verifyTitle(pageTitle), "Chua dung title");
        Assert.assertTrue(validateHelper.verifyURL(url), "Khong phai channel list");
        return new CreateChannelPage(driver);
    }

}
