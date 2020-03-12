package ua.weather.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "info";
    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
//        resourceBundle = ResourceBundle.getBundle(resourceName, new Locale("ru"));
//        resourceBundle = ResourceBundle.getBundle(resourceName, new Locale("ua"));
    }
    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
