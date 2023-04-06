package pages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class AbstractBasePage extends Base {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int BASE_WAIT = 15;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    public abstract void open();

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement getVisibilityElementByXpath(String locator) {
        return waitVisibilityOfElementLocated(locator);
    }

    protected WebElement getClickableElementByXpath(String locator) {
        return waitClickableElementByXpath(locator);
    }

    protected WebElement waitVisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            return null;
        }
    }
}
