package utils;

import org.openqa.selenium.Cookie;

public class CookieUtil {
    private static Cookie cookie;

    public static void putInScope(String key, String value) {
        cookie = new Cookie(key, value);
    }

    public static String getFromScope() {
        return cookie.getValue();
    }
}
