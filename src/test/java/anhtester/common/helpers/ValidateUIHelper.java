package anhtester.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateUIHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;
    private final int timeoutWaitForLoaded = 20;

    public ValidateUIHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void setText(By element, String value) {
        //send key 1 giá trị là value cho element truyền vào
        WebElement elementWaited = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementWaited.click();
        elementWaited.clear();
        elementWaited.sendKeys(value);
    }

    public boolean verifyElementText(By element, String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(), title);
        System.out.println("Da dung text element " + driver.findElement(element).getText());
        return true;
    }

    public void clickElement(By element) {
        WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementClick.click();
        waitForPageLoaded();
    }

    public void clickElementWithJS(By element) {
        waitForPageLoaded();
        //scroll to element with javascript
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        //click with js
        javascriptExecutor.executeScript("arguments[0].click();", driver.findElement(element));
    }

    public void scrolltoElement(By element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public void selectOptionByText(By element, String text) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(By element, String value) {
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

    public void selectOptionByIndex(By element, int index) {
        Select select = new Select(driver.findElement(element));
        select.selectByIndex(index);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForLoaded);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public boolean verifyURL(String url) {
        return driver.getCurrentUrl().contains(url);
    }

    public String getTitle() {
        waitForPageLoaded();
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyTitle(String favicon) {
        waitForPageLoaded();
        return getTitle().equals(favicon);
    }
}
