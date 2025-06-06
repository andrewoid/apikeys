package com.andrewoid.apikeys;

/**
 * This class will attempt to load one API key String from multiple locations.
 * This code should work both locally and when run with GitHub Actions.
 */
public class ApiKey {

    public static final String DEFAULT_LOCATION = "/apikey.properties";
    public static final String DEFAULT_KEY_NAME = "apikey";
    private final String key;

    /**
     * Loads the API key from the Properties file at the default location and default key name
     */
    public ApiKey() {
        this(DEFAULT_LOCATION, DEFAULT_KEY_NAME);
    }

    /**
     * Loads the API key from the Properties file at the specified location and specified keyName
     *
     * @param location the location of the Properties file within the Jar File
     * @param keyName  the key in the Properties file or the name of the environment variable.
     */
    public ApiKey(String location, String keyName) {
        Handler[] handlers = new Handler[]{
                new PropertiesHandler(location, keyName),
                new EnvironmentHandler(keyName)
        };
        String s = null;
        for (Handler h : handlers) {
            s = h.locate();
            if (s != null) {
                break;
            }
        }

        if (s == null) {
            throw new RuntimeException("No api key found for " + keyName + " at " + location);
        }

        key = s;
    }

    /**
     * Loads the API key from the Properties file at the default location and specified keyName
     *
     * @param keyName the key in the Properties file or the name of the environment variable.
     */
    public ApiKey(String keyName) {
        this(DEFAULT_LOCATION, keyName);
    }

    public String get() {
        return key;
    }

    @Override
    public String toString() {
        return "ApiKey{" + "key='" + key + '\'' + '}';
    }
}
