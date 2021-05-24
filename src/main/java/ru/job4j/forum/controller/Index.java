package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class Index {

    private final PostRepository postRepository;

    @Autowired
    public Index(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping({"/", "/index"})
    public String getIndex(Model model) {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        model.addAttribute("posts", posts);
        return "index";
    }
}
