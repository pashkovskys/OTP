package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import untils.SuiteConfiguration;

    @Log4j
public abstract class AbstractTestBase extends Base {

    protected WebDriver driver;

    @SneakyThrows
    @BeforeClass
    public void initTestSuit() {
        SuiteConfiguration config = new SuiteConfiguration();
        env = config.getProperty("site.url");
    }

    @BeforeMethod
    public void initDriver() {
        setUpDriver();
        setUpScreenResolution();
        log.info("-------------Start Test-------------");
    }

    private void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    private void setUpScreenResolution() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quiteDriver() {
        driver.quit();
        log.info("------------Finish Test--------------");
    }
}
