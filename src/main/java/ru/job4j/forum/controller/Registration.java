package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.memory.UserMemory;

@Controller
@RequestMapping("/job4j_forum")
public class Registration {

    private final UserMemory userMemory;

    public Registration(UserMemory userMemory) {
        this.userMemory = userMemory;
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String save(@ModelAttribute User user, Model model) {
        if (user.getName().equals("") || user.getPassword().equals("")) {
            model.addAttribute("message", "Введите все данные!");
            return "/registration";
        } else if (userMemory.findByName(user.getName()) != null) {
            model.addAttribute("message", "Такое имя уже существует!");
            return "/registration";
        }
        userMemory.save(user);
        return "login";
    }
}
