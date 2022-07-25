package com.simplilearn;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.Properties;

public class SystemPropertyTest {

    @Test
    void printSystemProperty(){
        Properties properties=System.getProperties();
        properties.forEach((k,v)-> System.out.println(k+":"+v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
    void onOpenJDK(){
        System.out.println("Run this in open JDK");
    }

    @Test
    @EnabledIfSystemProperty(named = "user.country", matches = "SG")
    void runOnCountrySingapore(){
        System.out.println("This will run only in Singapore");
    }

}
