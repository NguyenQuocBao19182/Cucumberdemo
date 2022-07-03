package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    public WebDriver driver;

    //static String driverPath = "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\";


    public WebDriver setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Hàm này để tùy chọn Browser. Cho chạy trước khi gọi class này (BeforeClass)
    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                driver.navigate().to(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver();
                driver.navigate().to(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
    }

    // Khởi tạo cấu hình của các Browser để đưa vào Switch Case

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        new BaseSetup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver(WebDriver driver) {
        return driver;
    }
//    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
//    @Parameters({ "browserType", "appURL" })
//    @BeforeClass
//    public void initializeTestBaseSetup(String browserType, String appURL) {
//        try {
//            // Khởi tạo driver và browser
//            setDriver(browserType, appURL);
//        } catch (Exception e) {
//            System.out.println("Error..." + e.getStackTrace());
//        }
//    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
//        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
//        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
//        // passed = SUCCESS và failed = FAILURE
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//                // Tạo tham chiếu của TakesScreenshot
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                // Gọi hàm capture screenshot - getScreenshotAs
//                File source = ts.getScreenshotAs(OutputType.FILE);
//                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
//                File theDir = new File("./Screenshots/");
//                if (!theDir.exists()) {
//                    theDir.mkdirs();
//                }
//                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
//                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
//                System.out.println("Đã chụp màn hình: " + result.getName());
//            } catch (Exception e) {
//                System.out.println("Exception while taking screenshot " + e.getMessage());
//            }
//        }
    }
}
