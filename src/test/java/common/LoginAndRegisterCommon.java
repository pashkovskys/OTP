package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public abstract class LoginAndRegisterCommon extends AbstractBasePage {

    protected LoginAndRegisterCommon(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmail() {
        return getVisibilityElementByXpath("//input[@id='login_field']");
    }

    public WebElement getPassword() {
        return getClickableElementByXpath("//input[@id='password']");
    }

    public WebElement getSubmitBtn() {
        return getClickableElementByXpath("//input[@name='commit']");
    }
}
