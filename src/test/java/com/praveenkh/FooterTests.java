package com.praveenkh;

import driverEngine.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTests extends BaseClass {

    private static WebDriver driver;

    private final String SITE = "https://praveenkh.com/";
    private final String COPYRIGHT_TEXT_FOOTER = "Copyright © 2022 Praveen K H - All Rights Reserved.";
    private final String YOUTUBE_CHANNEL_LINK = "https://www.youtube.com/channel/UCOmpwPOwUWrWejxsI-gRlbg";

    @BeforeClass
    public void startBrowser() {

        driver = getChromeDriver();
        driver.get(SITE);
    }

    @Test()
    public void Copyright() {
        final WebElement copyRightInFooter = driver.findElement(By.xpath("//*[@id=\"84018e6c-a859-4f30-b691-b5ffe8050167\"]/div/section/div[1]/div/div/div[1]/div/p/span"));
        Assert.assertEquals(COPYRIGHT_TEXT_FOOTER, getTextFromElement(copyRightInFooter), "Copyright text mismatch at footer");
    }

    @Test()
    public void Badminton() {
        final WebElement badmintonInFooter = driver.findElement(By.xpath("//*[@id=\"84018e6c-a859-4f30-b691-b5ffe8050167\"]/div/section/div[2]/ul/li[1]/a"));
        Assert.assertEquals("BADMINTON", getTextFromElement(badmintonInFooter), "Copyright text mismatch at footer");
        Assert.assertEquals(YOUTUBE_CHANNEL_LINK, badmintonInFooter.getAttribute("href"), "Copyright text mismatch at footer");
    }

    @AfterClass
    public void quiteBrowser() {
        driver.quit();
    }
}
