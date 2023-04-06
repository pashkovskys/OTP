package pages.signInPage;

import common.LoginAndRegisterCommon;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;

public class SignInPage extends LoginAndRegisterCommon {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openUrl(env);
    }

    public HomePage signInUser(String email, String password) {
        open();
        setEmail(email);
        setPassword(password);
        clickSignInBtn();
        return new HomePage(driver);
    }

    public SignInPage setEmail(String email) {
        getEmail().sendKeys(email);
        return new SignInPage(driver);
    }

    public SignInPage setPassword(String password) {
        getPassword().sendKeys(password);
        return new SignInPage(driver);
    }

    public SignInPage clickSignInBtn() {
        getSubmitBtn().click();
        return this;
    }
}
