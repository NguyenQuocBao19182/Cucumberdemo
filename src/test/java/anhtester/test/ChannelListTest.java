package anhtester.test;

import stepDefinitions.BaseSetup;
import anhtester.page.ChannelListPage;
import anhtester.page.CreateChannelPage;
import anhtester.page.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;

public class ChannelListTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ChannelListPage channelListPage;
    private CreateChannelPage createChannelPage;

    @BeforeClass
    public void setupChannelList() {
        driver=new BaseSetup().setupDriver("chrome");
        //driver = getDriver();
    }

    @Test(priority = 1)
    public void signIn(Method result) throws Exception {
        // Lúc này gọ class SignInPage ra dùng
        loginPage = new LoginPage(driver);
        driver.get("https://prod-dev.svcall.jp/");
        channelListPage = loginPage.login("nguyen.quoc.bao@sun-asterisk.com", "123@123a");

//        // Tạo tham chiếu của TakesScreenshot với driver hiện tại
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        // Gọi hàm capture screenshot - getScreenshotAs
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
//        File theDir = new File("./Screenshots/");
//        if (!theDir.exists()) {
//            theDir.mkdirs();
//        }
//        // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
//        FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
//        System.out.println("Screenshot taken: " + result.getName());
    }

    // Nó sẽ thực thi sau mỗi lần thực thi testcase (@Test)
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @Test(priority = 2)
    public void openChannelListPage() throws InterruptedException {
        createChannelPage = channelListPage.openChannelList();
    }

    @Test(priority = 3)
    public void createScheduleChannel() throws InterruptedException {
        createChannelPage.createScheduleChannel(4, "BaoScheduleAuto");
    }

    @Test(priority = 4)
    public void createDaiLyChannel() {
        createChannelPage.createDaiLyChannel(4, "BaoDaiLyAuto");
    }

    @AfterClass
    public void Close() {
        driver.close();
    }
}
