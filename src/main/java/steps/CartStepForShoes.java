package steps;

import pages.WomanShoesCataloguePage;
import utils.JsonDataUtil;

public class CartStepForShoes {

    public CartStepForShoes goToShoesCatalogueBuyAndCheckCart() {
        new WomanShoesCataloguePage()
                .chooseSelectedShoes(JsonDataUtil.get("testdata", "shoesSize"))
                .addShoesToCart()
                .goToCart();
        return this;
    }
}
