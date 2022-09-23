package drivers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrowserTypes {
    CHROME("chrome"),
    FIREFOX("firefox");

    String name;
}
