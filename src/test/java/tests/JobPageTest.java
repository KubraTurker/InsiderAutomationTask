package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;

public class JobPageTest extends BaseTest{
    @Test
    public void jobPageTest() throws InterruptedException {
        QAPage qaPage = new QAPage(this.driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        qaPage.go().check();
        PositionPage positionPage = qaPage.goPositions();
        positionPage.check();
        positionPage.filterLocation();
        positionPage.checkPosition();
        js.executeScript("window.scrollBy(0,600)");
        LeverPage leverPage = positionPage.visitPosition();
        leverPage.check();
    }
}

