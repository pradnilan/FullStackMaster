package com.simplilearn;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.DynamicTest.*;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestDemo {

    @TestFactory
    Collection<DynamicTest> myTest(){
        return Arrays.asList(
                dynamicTest("test 1",()->assertTrue(67>12)),
                dynamicTest("test 2",()->assertFalse(0>1)),
                dynamicTest("test 3",()->assertEquals(12,8+4)),
                dynamicTest("test 4",()->assertNull(null)),
                dynamicTest("test 5",()->assertThrows(RuntimeException.class,
                        ()->{throw new RuntimeException("not valid");})),
                dynamicTest("test 6",new myExecutable())

        );
    }

    class myExecutable implements Executable{

        @Override
        public void execute() throws Throwable {
            System.out.println("My Executable class");
        }
    }

}
