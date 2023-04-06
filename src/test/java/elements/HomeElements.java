package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class HomeElements extends AbstractBasePage {

    public HomeElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openUrl(env);
    }

    public WebElement getProject() {
        return getVisibilityElementByXpath("//input[@placeholder='Search or jump to…']");
    }

    public WebElement choiceProject() {
        return getClickableElementByXpath("//em[normalize-space()='b0hdan1']");
    }

    public WebElement getPomFile() {
        return getClickableElementByXpath("//a[.='pom.xml']");
    }

    public WebElement getSeleniumJava() {
        return getVisibilityElementByXpath("//tr[20]/td[@class='blob-code blob-code-inner js-file-line']");
    }

    public WebElement getTestNg() {
        return getVisibilityElementByXpath("//tr[26]/td[@class='blob-code blob-code-inner js-file-line']");
    }

    public WebElement getSeleniumApi() {
        return getVisibilityElementByXpath("//tr[32]/td[@class='blob-code blob-code-inner js-file-line']");
    }
}
