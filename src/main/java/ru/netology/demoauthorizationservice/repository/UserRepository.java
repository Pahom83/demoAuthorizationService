package ru.netology.demoauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.demoauthorizationservice.enums.Authorities;
import ru.netology.demoauthorizationservice.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.demoauthorizationservice.enums.Authorities.*;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    {
        User user1 = new User("Ivan", "pass1", List.of(READ));
        User user2 = new User("Petya", "pass2", List.of(WRITE));

        users.put(user1.getLogin(), user1);
        users.put(user2.getLogin(), user2);
    }

    public List<Authorities> getUserAuthorities(String login, String password) {
        User user = users.get(login);
        if (user != null && user.getPassword().equals(password)){
            return user.getAuthorities();
        }
        return null;
    }
}
