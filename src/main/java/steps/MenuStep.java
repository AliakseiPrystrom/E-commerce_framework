package steps;

import pages.HomePage;
import utils.JsonDataUtil;

public class MenuStep {

    public CartStepForBag chooseItemInMenu() {
        new HomePage()
                .openPage()
                .switchToMenMenu()
                .goToMenBackPacksPage()
                .getTestBag(JsonDataUtil.get("testdata", "backPack"))
                .openDetails()
                .chooseBagColor(JsonDataUtil.get("testdata", "backPackColor"));
        return new CartStepForBag();
    }
}
