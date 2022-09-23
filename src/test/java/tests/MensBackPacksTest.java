package tests;

import org.testng.annotations.Test;
import steps.MenuStep;

public class MensBackPacksTest extends BaseTest {

    @Test
    public void orderItemAndCheckItsPresenceInShoppingCart() {
        new MenuStep()
                .chooseItemInMenu()
                .validateItemPresenceInCartAndItdRequiredFields();
    }
}
