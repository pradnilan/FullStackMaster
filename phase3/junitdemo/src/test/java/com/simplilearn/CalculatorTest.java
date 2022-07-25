package com.simplilearn;

import org.junit.jupiter.api.*;

import javax.sound.midi.Soundbank;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private  Calculator cal;

    @BeforeEach
    void setUp() {
        System.out.println("Object Created");
        cal=new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Object destroyed");
        cal=null;
    }

    @Test @DisplayName("Addition")
    void add() {
        System.out.println("Add test executed");
        assertEquals(7,cal.add(3,4));
    }

    @Test @DisplayName("Subtraction")
    void subtract() {
        System.out.println("Subtract test executed");
        assertEquals(-9,cal.subtract(10,19));
    }

    @Test
    void mul() {
    }

    @Test
    void div() {
    }
}