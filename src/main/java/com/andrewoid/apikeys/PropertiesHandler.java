package com.andrewoid.apikeys;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler implements Handler {

    private final String location;
    private final String keyName;

    public PropertiesHandler(String location, String keyName) {
        this.location = location;
        this.keyName = keyName;
    }

    @Override
    @Nullable
    public String locate() {
        Properties properties = new Properties();
        InputStream in = ApiKey.class.getResourceAsStream(location);
        if (in != null) {
            try {
                properties.load(in);
                return properties.getProperty(keyName);
            } catch (IOException e) {
                throw new RuntimeException(
                        location + " file found but no " + keyName + " was found in the file.",
                        e);
            }
        }
        return null;
    }
}
