package com.codecool.apigateway.security;


import com.codecool.apigateway.model.AppUser;
import com.codecool.apigateway.repository.AppUserRepository;
import com.codecool.apigateway.service.UserServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private AppUserRepository users;

    @Autowired
    private UserServiceCaller userServiceCaller;

    public CustomUserDetailsService(AppUserRepository users) {
        this.users = users;
    }

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userServiceCaller.getUserByName(username);
        System.out.println(user.toString());
        // users.findByUsername(username)
               // .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));

        return new User(user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }

}
