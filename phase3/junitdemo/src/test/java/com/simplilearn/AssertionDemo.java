package com.simplilearn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionDemo {

    String getName(){
        return "prad";
    }

    boolean checkAge(int age){
        return age>=18;
    }

    @Test
    void testAssert1(){

        String expected="prad";
        assertEquals(expected,getName());

    }

    @Test
    void testAssert2(){
        assertTrue(checkAge(31));
        assertFalse(checkAge(16));
    }

    @Test
    void testAssert3(){
        String name=null;
        assertNull(name);

        name="simplilearn";
        assertNotNull(name);
    }

    @Test
    void testAssert4(){
        assertThrows(ArithmeticException.class,()->{int a=10/0;});
    }

    //passing executables as parameter called lambda in java

}
