package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    static String PAGE_URL = "https://useinsider.com/careers/";
    static By LOCATION_LOCATOR = By.xpath("//h3[normalize-space()='Our Locations']");
    static By TEAMS_LOCATOR = By.xpath("//h3[normalize-space()='Find your calling']");
    static By LIFE_LOCATOR = By.xpath("//h2[normalize-space()='Life at Insider']");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void check(){
        Assertions.assertEquals(driver.getCurrentUrl(), PAGE_URL);
    }

    public CareersPage checkLocation(){
        Assertions.assertDoesNotThrow(() -> driver.findElement(LOCATION_LOCATOR), "Location block not present");

        return this;
    }

    public CareersPage checkTeam(){
        Assertions.assertDoesNotThrow(() -> driver.findElement(TEAMS_LOCATOR), "Teams block not present");

        return this;
    }

    public CareersPage checkLife(){
        Assertions.assertDoesNotThrow(() -> driver.findElement(LIFE_LOCATOR), "Life block not present");

        return this;
    }
}

