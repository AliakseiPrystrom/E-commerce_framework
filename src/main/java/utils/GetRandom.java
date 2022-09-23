package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class GetRandom {
    private static final String DICT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    public static int getRandomValue(List<WebElement> list) {
        return random.nextInt(list.size());
    }

    public static String getRandomText() {
        int length = 9;
        StringBuilder sb = new StringBuilder();

        for (; length > 0; --length)
            sb.append(DICT.charAt(random.nextInt(DICT.length())));

        return sb.toString();
    }
}
