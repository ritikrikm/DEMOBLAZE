package com.carbocalc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final String CONFIG_FILE = "config/config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigReader() {
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Missing config file: " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load config file: " + CONFIG_FILE, exception);
        }
        return properties;
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        String fileValue = PROPERTIES.getProperty(key);
        if (fileValue == null || fileValue.isBlank()) {
            throw new IllegalArgumentException("Missing required config key: " + key);
        }
        return fileValue.trim();
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
