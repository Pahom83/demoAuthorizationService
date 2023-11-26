package ru.netology.demoauthorizationservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.demoauthorizationservice.enums.Authorities;

import java.util.List;
@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private List<Authorities> authorities;
}
