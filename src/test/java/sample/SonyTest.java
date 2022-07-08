package sample;

import driverEngine.BaseClass;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class SonyTest extends BaseClass {

    public static WebDriver driver;
    WebElement priceOfStandardEdition;
    @BeforeClass
    public void startBrowser(){

        driver = startChromeDriver();
    }

    @Test(priority = 1)
    public void FarCry6() throws Exception {

        driver.get("https://www.playstation.com/en-in/games/far-cry-6/");

        By chooseEditionButton = By.xpath("//*[@id=\"jetstream-tertiary-nav\"]/div/div/div[2]/a/span");
        Assert.assertEquals(driver.findElement(chooseEditionButton).getText(), "Choose edition and buy");
        clickOnElement(driver.findElement(chooseEditionButton));

        WebElement standardEdition = driver.findElement(By.xpath("//*[@id=\"buynow\"]/div/div/div/article[1]/div[2]/div[1]/h3"));
        Assert.assertEquals(standardEdition.getText(), "FAR CRY®6 Standard Edition PS4 & PS5", "Standard edition title mismatch");

        Thread.sleep(2000);

        priceOfStandardEdition = driver.findElement(By.xpath("//*[@id=\"buynow\"]/div/div/div/article[1]/div[2]/div[2]/div/div/label/div/span/span/span"));
        Assert.assertEquals(priceOfStandardEdition.getText(), "Rs 3,999");
    }

    @Test(priority = 2)
    public void BorderLands3() throws Exception {

        driver.get("https://www.playstation.com/en-in/games/borderlands-3/");

        WebElement titleText = driver.findElement(By.xpath("//*[@id=\"gdk__content\"]/div/div[1]/div/div[1]/div[2]/div[1]/h1"));
        Assert.assertEquals(titleText.getText(), "Borderlands 3", "Title mismatch");

        Thread.sleep(2000);
        priceOfStandardEdition = driver.findElement(By.xpath("//*[@id=\"gdk__content\"]/div/div[1]/div/div[1]/div[2]/div[1]/div[3]/div/div/label/div/span/span/span"));
        Assert.assertEquals(priceOfStandardEdition.getText(), "Rs 3,999");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        try {
            getScreenShot(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (result.getStatus() != ITestResult.SUCCESS) {

            getScreenShot(result);
            if (result.getThrowable().getMessage().startsWith("expected")) {
                driver.navigate().to("http://api.callmebot.com/text.php?source=web&user=@atomberg1991&text= Price Change noticed on " + result.getName() +", Latest price is : " + priceOfStandardEdition.getText());
            } else {
                driver.navigate().to("http://api.callmebot.com/text.php?source=web&user=@atomberg1991&text=Your PSN Scraper failed; " + result.getThrowable().getMessage());
            }
        }
    }

    @AfterClass
    public void quiteBrowser(){
        driver.quit();
        log("Browser closed .. Bye bye");
    }
}
