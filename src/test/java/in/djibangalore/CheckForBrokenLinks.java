package in.djibangalore;

import driverEngine.BrowserActions;
import driverEngine.BrowserEngine;
import lombok.extern.java.Log;
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
import java.util.Arrays;
import java.util.List;

@Log
public class CheckForBrokenLinks {
    private static WebDriver driver;
    private static BrowserActions browserActions;
    private final String SITE = "https://djibangalore.in";

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
        final List<Integer> allowedCodes = Arrays.asList(200, 201, 204);
        final String url = link;
        log.info("Url under test : [ " + url + " ]");
        if (url == null || url.isEmpty()) {
            System.out.println("URL is either not configured for anchor tag or it is empty");
        }

        try {
            final HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.setConnectTimeout(5000);
            huc.setRequestMethod("HEAD");
            huc.connect();
            final int respCode = huc.getResponseCode();
            Assert.assertTrue(allowedCodes.contains(respCode), "Broken Link : [ " + url + " ], response code found as [ "+ respCode +" ]");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            log.info(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.info(e.getMessage());
        }

    }

    @AfterClass
    public void quiteBrowser() {
        log.info("Quit driver after test");
        driver.quit();
    }

}
