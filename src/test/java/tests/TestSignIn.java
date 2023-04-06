package tests;

import helper.UserCreations;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.home.HomePage;
import pages.signInPage.SignInPage;

    @Log4j
public class TestSignIn extends AbstractTestBase {


    @Test
    public void checkLogin() {
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        signInPage.signInUser(UserCreations.USER_EMAIL, UserCreations.PASSWORD);
        homePage.setProject();
        log.info(" SeleniumJava " + homePage.getSeleniumJava().getText());
        log.info(" TestNg " + homePage.getTestNg().getText());
        log.info(" SeleniumApi " + homePage.getSeleniumApi().getText());

        Assert.assertEquals(homePage.getTestNg().getText().trim(), UserCreations.VERSION);
        log.info(" Expected result: " + UserCreations.VERSION);
        log.info(" Actual result: " + homePage.getTestNg().getText().trim());
    }
}
