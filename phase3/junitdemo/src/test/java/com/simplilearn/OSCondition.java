package com.simplilearn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OSCondition {

    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    void runOnWindows(){
        System.out.println("This test will run on Windows OS");
    }

    @Test
    @EnabledOnOs(value = OS.MAC)
    void runOnMac(){
        System.out.println("This test will run on MAC");
    }

    @Test
    @DisabledOnOs(value = OS.LINUX)
    void runNotLinux(){
        System.out.println("This will not run on Linux");
    }



}
