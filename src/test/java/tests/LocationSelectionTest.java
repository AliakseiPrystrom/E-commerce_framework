package tests;

import drivers.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JsonDataUtil;


public class LocationSelectionTest extends BaseTest {

    @Test
    public void checkLocationSelection() {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(WebDriverManager.getDriver().manage().window().getSize());
        Dimension dimension = new Dimension(1920, 1080);
        WebDriverManager.getDriver().manage().window().setSize(dimension);
        System.out.println(WebDriverManager.getDriver().manage().window().getSize());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");



        HomePage homePage = new HomePage()
                .openPage()
                .goToLocationSelection()
                .chooseLocation(JsonDataUtil.get("testdata", "location"))
                .goToShopping();
        Assert.assertTrue(homePage.checkCurrentLocation(), "current location fail");
    }
}
