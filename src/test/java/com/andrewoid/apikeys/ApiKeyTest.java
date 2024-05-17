package com.andrewoid.apikeys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiKeyTest {

    @Test
    public void get() {
        // given

        // when
        ApiKey apiKey = new ApiKey();

        // then
        assertEquals("0101010101", apiKey.get());
    }

}