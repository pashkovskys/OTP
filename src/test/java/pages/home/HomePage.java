package pages.home;

import elements.HomeElements;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomeElements {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage setProject() {
        getProject().sendKeys("b0hdan1/HT_2" + "\n");
        choiceProject().click();
        getPomFile().click();
        return new HomePage(driver);
    }
}



