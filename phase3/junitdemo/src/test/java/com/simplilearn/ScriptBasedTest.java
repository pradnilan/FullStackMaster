package com.simplilearn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

public class ScriptBasedTest {

    boolean myCondition(){
        return true;
    }
    @Test@EnabledIf("myCondition")
    void testScript(){
        System.out.println("Executed");
    }
}
