package ru.job4j.forum.service.memory;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserMemory {

    private final Map<String, User> users = new HashMap<>();

    public User save(User user) {
        users.put(user.getName(), user);
        return user;
    }

    public User findByName(String name) {
        return users.get(name);
    }
}
