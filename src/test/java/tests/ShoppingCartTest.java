package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import steps.FitnessPlateStep;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void orderItemAndCheckItsPresenceInShoppingCart() {
        CartPage page = new CartPage();
        new FitnessPlateStep()
                .goToFitnessPlate()
                .goToShoesCatalogueBuyAndCheckCart();
        Assert.assertTrue(page.checkArticle(), "Shoes don't match!");
    }
}
