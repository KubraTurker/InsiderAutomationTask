package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LeverPage extends BasePage {
    static String PAGE_URL="https://jobs.lever.co/useinsider/";

    public LeverPage(WebDriver driver) {
        super(driver);
    }

    public void check(){
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(PAGE_URL));
    }
}

