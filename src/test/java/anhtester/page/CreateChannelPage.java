//package anhtester.page;
//
//import anhtester.common.helpers.ValidateUIHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import java.util.List;
//
//public class CreateChannelPage {
//    private WebDriver driver;
//    private ValidateUIHelper validateHelper;
//    private By headerCreateChannel = By.xpath("//h2[contains(text(),'チャンネル作成')]");
//    private By CreateChannelbtn = By.xpath("//button[contains(text(),'チャンネル作成')]");
//    private By channelName_txt = By.xpath("//body/div[@id='headlessui-portal-root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/fieldset[1]/input[1]");
//    private By createChannel_btn = By.xpath("//body/div[@id='headlessui-portal-root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/button[2]");
//    private By dailyRadioButton = By.xpath("//span[contains(text(),'毎日')]");
//
//    public CreateChannelPage(WebDriver driver) {
//        this.driver = driver;
//        validateHelper = new ValidateUIHelper(driver);
//    }
//
//    public void createScheduleChannel(int column, String channelName) {
//        validateHelper.clickElement(CreateChannelbtn);
//        Assert.assertTrue(validateHelper.verifyElementText(headerCreateChannel, "チャンネル作成"), "Khong phai Create Channel pop-up");
//        validateHelper.setText(channelName_txt, channelName);
//        validateHelper.clickElement(createChannel_btn);
//        validateHelper.waitForPageLoaded();
//        List<WebElement> list_Schedule = driver.findElements(By.xpath("//table/tbody/tr"));
//        System.out.println("size Channel " + list_Schedule.size());
//        for (int i = 1; i <= list_Schedule.size(); i++) {
//            //tr là số dòng sẽ thay đổi
//            //td là số cột mình muốn check
//            By element = By.xpath("//tbody/tr[" + i + "]/td[" + column + "]");
//            WebElement item_Schedule = driver.findElement(element);
//            validateHelper.scrolltoElement(element);
//            if (item_Schedule.getText().contains(channelName) == true) {
//                System.out.println("Co " + item_Schedule.getText() + " Schedule Channel vua tao");
//                break;
//            }
//        }
//    }
//
//    public void createDaiLyChannel(int column, String channelName) {
//        validateHelper.clickElementWithJS(CreateChannelbtn);
//        Assert.assertTrue(validateHelper.verifyElementText(headerCreateChannel, "チャンネル作成"), "Khong phai Create Channel pop-up");
//        validateHelper.setText(channelName_txt, channelName);
//        validateHelper.clickElement(dailyRadioButton);
//        validateHelper.clickElement(createChannel_btn);
//        validateHelper.waitForPageLoaded();
//        List<WebElement> list_Schedule = driver.findElements(By.xpath("//table/tbody/tr"));
//        System.out.println("size Channel " + list_Schedule.size());
//        for (int i = 1; i <= list_Schedule.size(); i++) {
//            //tr là số dòng sẽ thay đổi
//            //td là số cột mình muốn check
//            By element = By.xpath("//tbody/tr[" + i + "]/td[" + column + "]");
//            WebElement item_Schedule = driver.findElement(element);
//            validateHelper.scrolltoElement(element);
//            if (item_Schedule.getText().contains(channelName) == true) {
//                System.out.println("Co " + item_Schedule.getText() + " Daily Channel vua tao");
//                break;
//            }
//        }
//    }
//}