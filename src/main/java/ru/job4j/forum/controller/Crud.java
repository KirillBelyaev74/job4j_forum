package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Date;

@Controller
@RequestMapping("/job4j_forum")
public class Crud {

    private final PostService postService;

    public Crud(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String getCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postService.save(post);
        return "redirect:/job4j_forum/";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam int id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postService.save(post);
        return "redirect:/job4j_forum/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        postService.delete(id);
        return "redirect:/job4j_forum/";
    }
}
