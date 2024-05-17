package com.andrewoid.apikeys;

public class ApiKey {

    public static final String APIKEY_PROPERTIES = "/apikey.properties";
    public static final String APIKEY = "apikey";
    private final String key;

    public ApiKey() {
        Handler[] handlers = new Handler[]{
                new PropertiesHandler(APIKEY_PROPERTIES, APIKEY),
                new EnvironmentHandler(APIKEY)
        };
        String s = null;
        for (Handler h : handlers) {
            s = h.locate();
            if (s != null) {
                break;
            }
        }

        if (s == null) {
            throw new RuntimeException("No api key found.");
        }

        key = s;
    }

    public String get() {
        return key;
    }

    @Override
    public String toString() {
        return "ApiKey{" + "key='" + key + '\'' + '}';
    }
}
