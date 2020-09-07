package com.codecool.userservice.controller;

import com.codecool.userservice.model.AppUser;
import com.codecool.userservice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/get-user/{username}")
    public AppUser getUser(@PathVariable String username){

        AppUser byUsername = appUserRepository.findByUsername(username);
        System.out.println(byUsername);
        return byUsername;
    }
}
