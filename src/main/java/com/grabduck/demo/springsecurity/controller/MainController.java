package com.grabduck.demo.springsecurity.controller;

import com.grabduck.demo.springsecurity.persistence.entity.Role;
import com.grabduck.demo.springsecurity.persistence.entity.User;
import com.grabduck.demo.springsecurity.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public User getMainPage() {
        User name = User.builder().username("name").authorities(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER)).password("12").build();

        userRepository.save(name);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("roles", user.getAuthorities().stream().map(Role::getAuthority).collect(joining(",")));
        return name;
    }

    @GetMapping("/login")
    @Secured("ROLE_USER")
    public Authentication getLogin() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
