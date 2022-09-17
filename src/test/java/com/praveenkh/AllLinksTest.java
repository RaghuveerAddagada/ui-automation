package com.praveenkh;

import driverEngine.BrowserActions;
import driverEngine.BrowserEngine;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Log
public class AllLinksTest {

    private static WebDriver driver;
    private static BrowserActions browserActions;
    private final String SITE = "https://www.praveenkh.com/";

    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        driver = BrowserEngine.getChromeDriver();
        browserActions = new BrowserActions(driver);

        log.info("Navigate to Home page before");
        driver.navigate().to(SITE);
    }

    @DataProvider(name = "allLinks")
    public Object[][] ab() {
        final List<WebElement> linksList = browserActions.getAllHrefLinksFromPage();

        Object [][] objArray = new Object[linksList.size()][];
        for(int i=0;i< linksList.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = linksList.get(i).getAttribute("href");
        }
        return objArray;
    }


    @Test(dataProvider = "allLinks")
    public void validateAllLinksWorking(final String link) {

        final String url = link;
        log.info("Url under test : [ " + url + " ]");
        if (url == null || url.isEmpty()) {
            System.out.println("URL is either not configured for anchor tag or it is empty");
        }

        try {
            final HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            final int respCode = huc.getResponseCode();
            Assert.assertEquals(respCode, 200, "Broken Link : [ " + url + " ]");

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @AfterClass
    public void quiteBrowser() {
        log.info("Quit driver after test");
        driver.quit();
    }

}
