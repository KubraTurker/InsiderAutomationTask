package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    static  String PAGE_URL="https://useinsider.com/";
    static String CTA_SELECTOR = "home_cta_container";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage go() {
        driver.get(PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CTA_SELECTOR)));

        return this;
    }

    public void check(){
        Assertions.assertDoesNotThrow(() -> driver.findElement(By.className(CTA_SELECTOR)),
                "Home page not loaded.");
    }
}

