package utils;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StringUtil {

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

    public static String deleteQuotes(String string) {
        char[] arr = string.toCharArray();
        arr[0] = Character.toLowerCase(' ');
        arr[arr.length - 1] = Character.toLowerCase(' ');
        return new String(arr).trim();
    }

    public static String correctEncode(String input) {
        byte[] stringBytes = input.getBytes();
        return new String(stringBytes, StandardCharsets.UTF_8);
    }
}
