package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class Index {

    private final PostService postRepository;

    @Autowired
    public Index(PostService postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping({"/", "/index"})
    public String getIndex(HttpSession httpSession, Model model) {
        model.addAttribute("posts", postRepository.findAll());
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        httpSession.setAttribute("userName", user.getUsername());
        return "index";
    }
}
