package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAPage extends BasePage{
    public static final By PAGE_TITLE_SELECTOR = By.xpath("//h1[normalize-space()='Quality Assurance']");
    public static final By POSITION_LINK_SELECTOR = By.linkText("See all QA jobs");
    static  String PAGE_URL="https://useinsider.com/careers/quality-assurance/";

    public QAPage(WebDriver driver) {
        super(driver);
    }

    public QAPage go() {
        driver.get(PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE_SELECTOR));

        return this;
    }

    public void check() {
        Assertions.assertDoesNotThrow(() -> PAGE_TITLE_SELECTOR, " QA Page not loaded.");
    }

    public PositionPage goPositions() {
        driver.findElement(POSITION_LINK_SELECTOR).click();

        return new PositionPage(driver);
    }
}

