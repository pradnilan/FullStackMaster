package com.simplilearn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RepeatedTestDemo {

    @DisplayName("My Test")
    @RepeatedTest(value = 3, name = "TestCase:{displayName} the current count is"+
    "{currentRepetition} out of {totalRepetitions}")
    void myTest(){
        System.out.println("Test Executed");
    }
}
