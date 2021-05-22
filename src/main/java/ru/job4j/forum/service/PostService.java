package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger index = new AtomicInteger(0);

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(index.incrementAndGet());
            posts.put(post.getId(), post);
        } else {
            posts.replace(post.getId(), post);
        }
        return post;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void delete(int id) {
        posts.remove(id);
    }
}
