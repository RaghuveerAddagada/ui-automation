package driverEngine;

import lombok.extern.java.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@Log
public class BrowserActions {

    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;

        //TODO Check that we're on the right page by asserting page title or URL
    }

    public void clickOnElement(final By element) {
        log.info("webdriver performing click on -> {" + element + "}");
        driver.findElement(element).click();
    }

    public String getTextFromElement(final By element) {
        log.info("webdriver performing get text from element -> {" + element + "}");
        return driver.findElement(element).getText();
    }

    public String getAttributeFromElement(final By element, final String attribute) {
        log.info("webdriver performing get attribute [" + attribute + "] from element -> {" + element + "}");
        return driver.findElement(element).getAttribute(attribute);
    }

    public String getCurrentUrl() {
        log.info("webdriver get current URL");
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        log.info("webdriver get current page Title");
        return driver.getTitle();
    }

    public List<WebElement> getAllHrefLinksFromPage() {
        log.info("Get all href links in the page");
        return driver.findElements(By.xpath("//*[@href]"));
    }

    public void scrollToElement(final WebElement element) {
        log.info("webdriver performing scroll to element -> {" + element + "}");
        Actions a = new Actions(driver);
        a.moveToElement(element);
        a.perform();
    }

    private Properties readPropertyFile(final String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(fileName));
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return properties;
    }

    public void getScreenShot(ITestResult result) {

        // To create reference of TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Call method to capture screenshot
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        // Copy method  specific location here it will save all screenshot in our project home directory and
        // result.getName() will return name of test case so that screenshot name will be same
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop";
            FileHandler.copy(source, new File(desktopPath + "/" + result.getName() + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}
