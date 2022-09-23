package utils;

import java.util.Locale;

public class CheckStringForBagsUtil {

    public static boolean compareStrings(String testValue, String valueFromPage) {
        int count = 0;
        valueFromPage = valueFromPage.toLowerCase(Locale.ROOT).trim();
        String[] arr = testValue.toLowerCase(Locale.ROOT).split(" ");
        for (String testStrings : arr) {
            testStrings.trim();
        }
        for (String s : arr) {
            if (valueFromPage.contains(s)) {
                count++;
            }
        }
        return count == arr.length;
    }
}
