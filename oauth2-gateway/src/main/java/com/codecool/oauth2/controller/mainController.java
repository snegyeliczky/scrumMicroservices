package com.codecool.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping("/")
    public String helloWord(){
        return "Hello";
    }

    @GetMapping("/restricted")
    public String restricted(){
        return "With Oauth";
    }

}
