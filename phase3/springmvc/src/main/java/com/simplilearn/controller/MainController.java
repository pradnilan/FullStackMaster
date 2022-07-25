package com.simplilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class MainController {


    @RequestMapping("/register")
    public String handleRequest(){
        return "register";
    }
}
