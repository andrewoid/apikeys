package com.andrewoid.apikeys;

import org.jetbrains.annotations.Nullable;

public class EnvironmentHandler implements Handler {

    private final String keyName;

    public EnvironmentHandler(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public @Nullable String locate() {
        return System.getenv(keyName);
    }
}
