package pages;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    static Duration VISIBILITY_TIMEOUT = Duration.ofSeconds(5);

    BasePage(WebDriver driver){
        this.driver = driver;
    }
}
