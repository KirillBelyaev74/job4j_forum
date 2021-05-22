package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.forum.service.PostService;

@Controller
@RequestMapping("/job4j_forum")
public class Index {

    private final PostService postService;

    @Autowired
    public Index(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }
}
