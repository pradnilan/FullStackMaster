package com.simplilearn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JreConditionTest {

    @Test
    @EnabledOnJre(value = JRE.JAVA_8)
    void runOnJre8(){
        System.out.println("This test will run on JRE 8");
    }

    @Test
    @EnabledOnJre(value = JRE.JAVA_11)
    void runOnJre11(){
        System.out.println("This test will run on JRE 11");
    }

    @Test
    @EnabledOnJre(value = JRE.JAVA_18)
    void runOnJre18(){
        System.out.println("This test will run on JRE 18");
    }

}
