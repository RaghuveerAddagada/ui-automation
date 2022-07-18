package driverEngine;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;


    public static WebDriver startFirefoxDriver() {
        driver = new FirefoxDriver();
        log("Firefox driver started successfully");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver startChromeDriver() {
        final String driverPath = System.getProperty("user.dir");

        if (System.getProperty("os.name").startsWith("Mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/drivers/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            // TODO
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/drivers/chromedriver_linux");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless",
                "--disable-gpu",
                "--window-size=1920,1200",
                "--ignore-certificate-errors",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        log("Chrome driver started successfully");

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This method is used to Log messages in std out
     *
     * @param messageToLog message you wanted to log
     */
    public static void log(final String messageToLog) {
        Reporter.log(messageToLog, true);
    }


    public void clickOnElement(final WebElement element) {
        log("---> webdriver performing click");
        element.click();
    }

    public void scrollToElement(final WebElement element) {
        log("---> webdriver performing scroll to element");
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
            log(e.getMessage());
        } catch (IOException e) {
            log(e.getMessage());
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

    public Properties readLocators() {
        return readPropertyFile("locators.properties");
    }

    public Properties readCredentials() {
        return readPropertyFile("credentials.properties");
    }
}
