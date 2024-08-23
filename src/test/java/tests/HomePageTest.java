package tests;

import org.junit.jupiter.api.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.NavigationBar;

public class HomePageTest extends BaseTest{
    @Test
    public void homePageTest() throws InterruptedException {
        HomePage homepage = new HomePage(this.driver);
        homepage.go().check();
        NavigationBar navigationbar = new NavigationBar(this.driver);
        CareersPage careersPage = navigationbar.company().goCareer();
        careersPage.check();
        careersPage.checkLocation().checkTeam().checkLife();
    }
}
