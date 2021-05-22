package ru.job4j.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.repository.PostRepository;

import java.util.Date;

@Controller
@RequestMapping("/job4j_forum")
public class Crud {

    private final PostRepository postRepository;

    @Autowired
    public Crud(PostRepository postRepository) {
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
        return "redirect:/job4j_forum/";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam int id, Model model) {
        Post post = postRepository.findById(id).get();
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postRepository.save(post);
        return "redirect:/job4j_forum/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Post post = new Post();
        post.setId(id);
        postRepository.delete(post);
        return "redirect:/job4j_forum/";
    }
}
