package utils;

import elements.Input;

public class ShowValidationUtil {

    public static void sendAndClear(Input input) {
        input.sendKeys(GetRandom.getRandomText());
        input.clearInput();
    }
}
