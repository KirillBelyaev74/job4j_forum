package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Date;

@Controller
@RequestMapping
public class Crud {

    private final PostService postRepository;

    @Autowired
    public Crud(PostService postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/create")
    public String getCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam int id, Model model) {
        Post post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        postRepository.deleteById(id);
        return "redirect:/";
    }
}
