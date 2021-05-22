package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/job4j_forum")
public class Login {

    private final UserService userService;

    @Autowired
    public Login(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request) {
        User result = userService.findByName(user.getName());
        if (result == null || !result.equals(user)) {
            model.addAttribute("message", "Имя или пароль введены некорректно!");
            return "login";
        } else {
            request.getSession().setAttribute("user", user);
            return "index";
        }
    }
}
