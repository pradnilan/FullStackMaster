package com.simplilearn;

import org.junit.jupiter.api.*;

@DisplayName("Outer Class")
public class NestedTestDemo {

    @BeforeEach
    void setUp(){
        System.out.println("Before each of outer");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After each of outer");
    }

    @Test
    void myTest(){
        System.out.println("Test case of outer class");
    }

    @Nested
    class Inner{
        @BeforeEach
        void setUp(){
            System.out.println("Before each of inner");
        }

        @AfterEach
        void tearDown(){
            System.out.println("After each of inner");
        }

        @Test
        void myTest(){
            System.out.println("Test case of outer inner");
        }
    }

}
