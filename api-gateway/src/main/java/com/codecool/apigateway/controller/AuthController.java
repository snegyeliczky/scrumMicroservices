package com.codecool.apigateway.controller;

import com.codecool.apigateway.model.AppUser;
import com.codecool.apigateway.model.credentials.UserCredentials;
import com.codecool.apigateway.service.AuthService;
import com.codecool.apigateway.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private Environment env;

    @Autowired
    private Util util;

    private final PasswordEncoder passwordEncoder;

    public AuthController(){
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



    private void logInfo(){
        log.info("port: "+env.getProperty("server.port")+" called at: "+ LocalDateTime.now());
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserCredentials newUser){
        logInfo();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return authService.registration(newUser);
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody UserCredentials user, HttpServletResponse response){
        logInfo();
        return authService.signIn(user,response);
    }

    @GetMapping("/logout")
    public ResponseEntity logOut(HttpServletResponse response){
        return authService.logout(response);
    }


    @GetMapping("/get-user")
    public AppUser getUserFromContext(){
        return util.getUserFromContext();
    }
}
