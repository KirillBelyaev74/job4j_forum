package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

@Controller
@RequestMapping
public class Registration {

    private final UserService userRepository;
    private final AuthorityService authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Registration(UserService userRepository, AuthorityService authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String save(@ModelAttribute User user, Model model) {
        String url;
        String message;
        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            message = "Введите все данные пожалуйста!";
            url = "registration";
        } else if (userRepository.isHave(user.getUsername())) {
            message = "Пользователь с таким именем уже существует!";
            url = "registration";
        } else {
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
            userRepository.save(user);
            message = "";
            url = "login";
        }
        model.addAttribute("message", message);
        return url;
    }
}
