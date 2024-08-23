package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PositionPage extends BasePage {
    public static final By POSITION_ITEM_SELECTOR = By.className("position-list-item-wrapper");
    public static final By POSITION_TITLE_SELECTOR = By.className("position-title");
    public static final By POSITION_DEPARTMENT_SELECTOR = By.className("position-department");
    public static final By POSITION_LOCATION_SELECTOR = By.className("position-location");
    public static final By POSITION_ITEM_BOX_SELECTOR = By.className("position-list-item");
    public static final By VIEW_ROLE_BUTTON_SELECTOR = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");
    public static final By LOCATION_DROPDOWN_SELECTOR = By.className("select2-container");
    public static final By LOCATION_OPTION_SELECTOR = By.xpath("//li[@class='select2-results__option' and text()='Istanbul, Turkey']");
    public static final By POSITION_PAGE_TITLE_SELECTOR = By.xpath("//h3[normalize-space()='Browse Open Positions']");
    public static final By QUALITY_ASSURANCE_OPTION_SELECTOR = By.xpath("//span[@class='select2-selection__rendered' and text()='Quality Assurance']");

    public PositionPage(WebDriver driver) {
        super(driver);
    }


    public void check() {
        Assertions.assertDoesNotThrow(() -> POSITION_PAGE_TITLE_SELECTOR, "Position Page not loaded.");
    }

    public PositionPage filterLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(QUALITY_ASSURANCE_OPTION_SELECTOR));
        Thread.sleep(1000);
        driver.findElement(LOCATION_DROPDOWN_SELECTOR).click();
        driver.findElement(LOCATION_OPTION_SELECTOR).click();
        Thread.sleep(5000);

        return this;
    }

    public void checkPosition(){
        List<WebElement> elements = driver.findElements(POSITION_ITEM_SELECTOR);
        for(WebElement element : elements) {
            String positionTitle = element.findElement(POSITION_TITLE_SELECTOR).getText();
            Assertions.assertTrue(positionTitle.contains("Quality Assurance") || positionTitle.contains("QA"));
            String positionDepartment = element.findElement(POSITION_DEPARTMENT_SELECTOR).getText();
            Assertions.assertTrue(positionDepartment.contains("Quality Assurance"));
            String positionLocation = element.findElement(POSITION_LOCATION_SELECTOR).getText();
            Assertions.assertTrue(positionLocation.contains("Istanbul, Turkey"));
        }
    }

    public LeverPage visitPosition() throws InterruptedException {
        WebElement position = driver.findElement(POSITION_ITEM_BOX_SELECTOR);
        Actions actions = new Actions(driver);
        actions.moveToElement(position).perform();
        Thread.sleep(500);
        driver.findElement(VIEW_ROLE_BUTTON_SELECTOR).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();

        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        return new LeverPage(driver);
    }
}

