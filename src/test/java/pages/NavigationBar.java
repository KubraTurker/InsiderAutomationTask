package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar extends BasePage {
    static By NAVBAR_SELECTOR = By.className("navbar-nav");
    static By COMPANY_BUTTON_SELECTOR = By.xpath("//a[normalize-space()='Company']");
    static By COMPANY_BOX_SELECTOR = By.cssSelector(".dropdown-menu.new-menu-dropdown-layout-6.show");
    static By CAREER_LINK_SELECTOR = By.linkText("Careers");

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public NavigationBar company() {
        WebDriverWait wait = new WebDriverWait(this.driver, VISIBILITY_TIMEOUT);
        WebElement navbar = wait.until(ExpectedConditions.visibilityOfElementLocated(NAVBAR_SELECTOR));
        WebElement element = navbar.findElement(COMPANY_BUTTON_SELECTOR);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMPANY_BOX_SELECTOR));

        return this;
    }

    public CareersPage goCareer() {
        WebElement companyBox = driver.findElement(COMPANY_BOX_SELECTOR);
        companyBox.findElement(CAREER_LINK_SELECTOR).click();

        return new CareersPage(driver);
    }
}
