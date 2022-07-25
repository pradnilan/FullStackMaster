package com.simplilearn;

import org.junit.jupiter.api.*;

public class MyFirstTest {

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("Before All tests");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("After all test cases");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before each test case");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After each test case");
    }

    @Disabled
    @Test @DisplayName("Test for data insertion")
    void test1() {
        System.out.println("Junit test case 1");
    }

    @Test @DisplayName("Test for data retrieve")
    void test2() {
        System.out.println("Junit test case 2");
    }
}
