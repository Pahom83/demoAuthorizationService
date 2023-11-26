package ru.netology.demoauthorizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.demoauthorizationservice.enums.Authorities;
import ru.netology.demoauthorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}