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
        WebDriverManager.getDriver().manage().window().setSize(new Dimension(1024, 768));
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
