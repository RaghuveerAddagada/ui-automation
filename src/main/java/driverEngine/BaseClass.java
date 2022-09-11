package driverEngine;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log
public class BaseClass {

    public static WebDriver driver;


    public static WebDriver startFirefoxDriver() {
        driver = new FirefoxDriver();
        log.info("Firefox driver started successfully");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        //"--headless",
        options.addArguments(
                "--disable-gpu",
                "--window-size=1920,1200",
                "--ignore-certificate-errors",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage");

        WebDriverManager.chromedriver().setup();
        log.info("Chrome driver started successfully");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }


    public void clickOnElement(final WebElement element) {
        log.info("webdriver performing click on -> {" + element + "}");
        element.click();
    }

    public String getTextFromElement(final WebElement element) {
        log.info("webdriver performing get text from element -> {" + element + "}");
        return element.getText();
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
            InputStream inputStream = new FileInputStream(fileName);
            properties.load(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
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
