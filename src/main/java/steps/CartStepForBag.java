package steps;

import pages.BagPage;

public class CartStepForBag {

    public CartStepForBag validateItemPresenceInCartAndItdRequiredFields() {
        new BagPage()
                .addBagToCart()
                .goToCart()
                .validateRequiredCartFields();
        return this;
    }
}
