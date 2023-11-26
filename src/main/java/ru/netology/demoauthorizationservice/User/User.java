package ru.netology.demoauthorizationservice.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.demoauthorizationservice.Enums.Authorities;

import java.util.List;
@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private List<Authorities> authorities;
}
