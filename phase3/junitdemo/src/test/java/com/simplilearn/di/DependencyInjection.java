package com.simplilearn.di;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DependencyInjection {

    @Test @DisplayName("Method for TestInfo")
    void myTest(TestInfo testInfo){
        assertEquals("Method for TestInfo",testInfo.getDisplayName());
    }

    @Test @DisplayName("Method for tag")
    @Tag("demo")
    void myTest2(TestInfo testInfo){
        assertEquals("Method for tag",testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("demo"));
    }
}
