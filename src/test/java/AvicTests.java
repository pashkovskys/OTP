import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AvicTests {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test
    public void checkActualHeaderPhoneNumbers() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='header-top__item']/a[contains(text(),'0-800-307-900')]"));
        assertTrue(list.size() > 0, "Number is not actual");
    }

    @Test
    public void checkInstallmentPayment() {
        driver.findElement(By.xpath("//a[contains(@href, 'elektronika')][contains(@class, 'sidebar-item')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@href, 'monitoryi')][contains(@class, 'image-brand')]")).click();
        Actions action = new Actions(driver);
        WebElement filterCheckbox = driver.findElement(By.xpath("//input[@id='fltr-1']"));
        action.moveToElement(filterCheckbox).click().build().perform();
        driver.findElement(By.xpath("//a[contains(@href, 'eizo-ev2450-bk-item')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Купить в рассрочку')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Колібрі')]")).click();
        assertTrue(driver.getCurrentUrl().contains("#js_myCredit"));
    }

    @Test
    public void checkCallBack() {
        driver.findElement(By.xpath("//a[@id='bingc-phone-button']")).click();
        driver.findElement(By.xpath("//input[@id='bingc-passive-get-phone-form-input']")).sendKeys("0931111123");
        driver.findElement(By.xpath("//a[@id='bingc-passive-phone-form-button']")).click();
        assertTrue(driver.getPageSource().contains("bingc-we-already-call-you"));
    }

    @Test
    public void tradeInCheck() {
        driver.findElement(By.xpath("//a[contains(@href,  '/tradein')][@class='header-top__item']")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Да')]")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//div[@class='tab'][4]/div/div/button[contains(text(), 'Да')]")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Дисплей и корпус не имеет царапин и сколов')]")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Полный комплект')]")).click();
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        driver.findElement(By.xpath("//input[@data-bind='name']")).sendKeys("Николай Басков");
        driver.findElement(By.xpath("//input[@data-bind='phone']")).sendKeys("0958472857");
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
        assertTrue(driver.getCurrentUrl().contains("/thankyou?"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
