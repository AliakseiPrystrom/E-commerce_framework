package steps;

import pages.HomePage;

public class FitnessPlateStep {

    public CartStepForShoes goToFitnessPlate() {
        new HomePage()
                .openPage()
                .goToSportPage()
                .goFitnessPlate()
                .chooseShoes();
        return new CartStepForShoes();
    }
}
