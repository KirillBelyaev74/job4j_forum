package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}
