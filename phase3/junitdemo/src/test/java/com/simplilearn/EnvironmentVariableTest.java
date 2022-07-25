package com.simplilearn;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.Map;

public class EnvironmentVariableTest {

    @Test @Disabled
    void getEnvironmentVariables(){
        Map<String,String> map=System.getenv();
        map.forEach((k,v)->System.out.println(k+":"+v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS",matches = "8")
    void onProcessor4(){
        System.out.println("Run if processors are 4");
    }

}
