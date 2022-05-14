package anhtester.test;

import stepDefinitions.BaseSetup;
import anhtester.common.helpers.ValidateUIHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCode {
    private WebDriver driver;
    private ValidateUIHelper validateUIHelper;

    @BeforeClass
    public void setupDriver() {
        driver= new BaseSetup().setupDriver("chrome");
        validateUIHelper = new ValidateUIHelper(driver);
    }

    @Test
    public void loginPage(){
        driver.get("");
        driver.findElement(By.xpath("")).click();
    }
    @AfterClass
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
