package com.example.springsecurity2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {


    @GetMapping("/")
    public String getHello(){
        return "Hello";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String user(){
        return "Hello USer";
    }

}
