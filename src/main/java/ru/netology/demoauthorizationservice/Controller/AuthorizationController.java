package ru.netology.demoauthorizationservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.demoauthorizationservice.Enums.Authorities;
import ru.netology.demoauthorizationservice.Service.AuthorizationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("login") String login, @RequestParam("password") String password) {
        return service.getAuthorities(login, password);
    }

}