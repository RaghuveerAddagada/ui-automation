package in.djibangalore;

import driverEngine.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private final BrowserActions browserActions;

    final By DJI_BANGALORE_LEFT_TOP_LOGO = By.xpath("//*[@id=\"logo-text-9801\"]");
    final By HOME_IN_HEADER = By.xpath("//*[@id=\"nav-9802\"]/li[1]/a");
    final By SHOP_IN_HEADER = By.xpath("//*[@id=\"nav-9802\"]/li[2]/a");
    final By REVIEWS_IN_HEADER = By.xpath("//*[@id=\"nav-9802\"]/li[3]/a");
    final By CONTACT_US_IN_HEADER = By.xpath("//*[@id=\"nav-9802\"]/li[4]/a");
    final By INSTAGRAM_IN_HEADER = By.xpath("//*[@id=\"nav-9802\"]/li[5]/a");

    final By PHONE_NUMBER_IN_HOME_PAGE = By.xpath("//*[@id=\"n-9786\"]/div/section/div[2]/div/div[2]/div[2]/div[2]/p");

    final By FEATURED_PRODUCTS = By.xpath("//*[@id=\"bs-10\"]/span/div/h2/span");
    final By VIEW_ALL_PRODUCTS = By.xpath("//*[@id=\"bs-10\"]/span/div/div/div/div/div[2]/a/span");
    final By VIDEO = By.xpath("//*[@id=\"33ac290d-c1f8-4a97-94f3-23ea8b3f5d8f\"]/div/section/div/h2/span");
    final By CONTACT_US = By.xpath("//*[@id=\"a432c104-8839-403e-a697-baf281613ffb\"]/div/section/div/div[1]/div/h2/span");

    public HomePage(WebDriver driver) {
        browserActions = new BrowserActions(driver);
    }

    public void validateHeaderMenuItems() {
        Assert.assertEquals(browserActions.getCurrentPageTitle(), "DJI BANGALORE", "Title mismatch at Home page");
        Assert.assertEquals(browserActions.getTextFromElement(DJI_BANGALORE_LEFT_TOP_LOGO), "DJI BANGALORE", "LEFT_TOP Logo Text is missing");
        Assert.assertEquals(browserActions.getTextFromElement(HOME_IN_HEADER),"Home", "Home Link in Home page menu is missing");
        Assert.assertEquals(browserActions.getTextFromElement(SHOP_IN_HEADER),"SHOP", "Shop Link in Home page menu is missing");
        Assert.assertEquals(browserActions.getTextFromElement(REVIEWS_IN_HEADER),"REVIEWS", "Reviews in Home page menu is missing");
        Assert.assertEquals(browserActions.getTextFromElement(CONTACT_US_IN_HEADER),"CONTACT US", "Contact Us in Home page menu is missing");
        Assert.assertEquals(browserActions.getTextFromElement(INSTAGRAM_IN_HEADER), "INSTAGRAM", "Instagram in Home page menu is missing");
        Assert.assertEquals(browserActions.getTextFromElement(PHONE_NUMBER_IN_HOME_PAGE), "Call on +91-8095086806 for Special Discounts", "Contact number has been changed");
        Assert.assertEquals(browserActions.getTextFromElement(FEATURED_PRODUCTS), "FEATURED PRODUCTS", "Featured products heading is not present");
        Assert.assertEquals(browserActions.getTextFromElement(VIEW_ALL_PRODUCTS), "View All Products", "View all products link is missing in feature products");
        Assert.assertEquals(browserActions.getTextFromElement(VIDEO), "VIDEO", "Video tab is missing in Home page");
        Assert.assertEquals(browserActions.getTextFromElement(CONTACT_US), "CONTACT US", "Contact us tab in home page");
    }

}
