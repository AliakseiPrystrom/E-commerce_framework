package tests;

import drivers.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JsonDataUtil;

public class LocationSelectionTest extends BaseTest {

    @Test
    public void checkLocationSelection() {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(WebDriverManager.getDriver().manage().window().getSize());

        HomePage homePage = new HomePage()
                .openPage()
                .goToLocationSelection()
                .chooseLocation(JsonDataUtil.get("testdata", "location"))
                .goToShopping();
        Assert.assertTrue(homePage.checkCurrentLocation(), "current location fail");
    }
}
