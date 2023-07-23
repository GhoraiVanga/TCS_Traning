package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DynamicTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationEngineDynamicTest {

    private TranslatorEngine translatorEngine;
    @BeforeEach
    public void setUp() {
           translatorEngine = new TranslatorEngine();
    }

    @Test
    public void testTranlsateHello() {
        assertEquals("Bonjour", translatorEngine.tranlate("Hello"));
    }

    @Test
    public void testTranlsateYes() {
        assertEquals("Oui", translatorEngine.tranlate("Yes"));
    }

    @Test
    public void testTranlsateNo() {
        assertEquals("Non", translatorEngine.tranlate("No"));
    }

    @Test
    public void testTranlsate_Not_Found() {
        assertEquals("Not found", translatorEngine.tranlate(""));
    }


}
