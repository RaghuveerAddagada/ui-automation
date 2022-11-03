package in.djibangalore;

import driverEngine.BrowserActions;
import org.openqa.selenium.WebDriver;

public class ShopPage {

    private final BrowserActions browserActions;

    public ShopPage(WebDriver driver) {
        browserActions = new BrowserActions(driver);
    }


}
