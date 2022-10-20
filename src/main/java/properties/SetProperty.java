package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class SetProperty {
    private static SetProperty instance;
    private final Properties properties = new Properties();
    private Map<String, Properties> propMap = new HashMap<>();

    private SetProperty() {
    }

    public static synchronized SetProperty getInstance() {
        if (instance == null) {
            instance = new SetProperty();
        }
        return instance;
    }

    public Properties readProperty(String file) {
        if (!propMap.containsKey(file)) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new UncheckedIOException(e);
            }
            propMap.put(file, properties);
        }
        return propMap.get(file);
    }

    public String getProperty(String file, String key) {
        readProperty(file);
        return propMap.get(file).getProperty(key);
    }
}
