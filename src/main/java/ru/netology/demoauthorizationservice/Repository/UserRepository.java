package ru.netology.demoauthorizationservice.Repository;

import org.springframework.stereotype.Repository;
import ru.netology.demoauthorizationservice.Enums.Authorities;
import ru.netology.demoauthorizationservice.User.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.demoauthorizationservice.Enums.Authorities.*;

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
