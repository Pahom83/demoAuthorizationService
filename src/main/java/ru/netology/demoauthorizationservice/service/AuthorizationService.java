package ru.netology.demoauthorizationservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.demoauthorizationservice.enums.Authorities;
import ru.netology.demoauthorizationservice.exception.InvalidCredentials;
import ru.netology.demoauthorizationservice.exception.UnauthorizedUser;
import ru.netology.demoauthorizationservice.repository.*;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String login, String password) {
        if (isEmpty(login) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(login, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + login);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}