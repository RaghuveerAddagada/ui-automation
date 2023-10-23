package driverEngine;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@Log
public class BrowserEngine {

    public static WebDriver driver;

    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        log.info("Firefox driver started successfully");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getChromeDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new",
                "--disable-gpu",
                "--window-size=1920,1200",
                "--ignore-certificate-errors",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage");

        WebDriverManager.chromedriver().setup();
        log.info("Chrome driver started successfully");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
