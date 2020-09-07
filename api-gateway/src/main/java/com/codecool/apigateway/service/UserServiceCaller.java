package com.codecool.apigateway.service;

import com.codecool.apigateway.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user-service.url}")
    private String baseUrl;


    public AppUser getUserByName(String username){
        ResponseEntity<AppUser> forEntity = restTemplate.getForEntity(baseUrl + "/get-user/" + username, AppUser.class);
        AppUser body = forEntity.getBody();
        return body;
    }


}
