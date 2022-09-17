package com.praveenkh;

import com.praveenkh.pages.HomePageFooter;
import driverEngine.BrowserEngine;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Log
public class FooterTests {

    private static WebDriver driver;
    private HomePageFooter homePageFooter;

    private final String SITE = "https://www.praveenkh.com/";

    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        driver = BrowserEngine.getChromeDriver();
        homePageFooter = new HomePageFooter(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTestNavigateToHomePage() {
        log.info("Navigate to Home page before");
        driver.navigate().to(SITE);
    }

    @Test()
    public void ValidateCopyright() {
        homePageFooter.validateCopyright();
    }

    @Test()
    public void ValidateBadminton() {
        homePageFooter.validateBadminton();
    }

    @Test()
    public void ValidatePrivacyPolicy() {
        homePageFooter
                .validatePrivacyPolicy()
                .clickOnPrivacyPolicy()
                .validatePrivacyPolicyPageContent();
    }

    @Test()
    public void ValidateTermsAndConditions() {
        homePageFooter
                .validateTermsAndConditions()
                .clickOnTermsAndConditions()
                .validateTermsAndConditionsPageContent();
    }

    @AfterClass
    public void quiteBrowser() {
        log.info("Quit driver after test");
        driver.quit();
    }
}
