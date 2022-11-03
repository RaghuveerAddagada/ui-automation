package in.djibangalore;

import driverEngine.BrowserActions;
import driverEngine.BrowserEngine;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log
public class HomePageTests {

    private static WebDriver driver;
    private static BrowserActions browserActions;

    private HomePage homePage;

    private final String SITE = "https://djibangalore.in";

    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        driver = BrowserEngine.getChromeDriver();
        browserActions = new BrowserActions(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTestNavigateToHomePage() {
        log.info("Navigate to Home page before");
        driver.navigate().to(SITE);
    }

    @Test(priority = 1)
    public void ValidatePageElements() {
        homePage.validateHeaderMenuItems();

    }

    @Test(priority = 2)
    public void ShopPageFiltersTest() {

    }






    @AfterClass
    public void quiteBrowser() {
        log.info("Quit driver after test");
        driver.quit();
    }
}
