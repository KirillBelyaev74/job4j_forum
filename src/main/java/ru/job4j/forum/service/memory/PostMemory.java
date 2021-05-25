package ru.job4j.forum.service.memory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Service
public class PostMemory {

    private final Map<Integer, ru.job4j.forum.model.Post> posts = new HashMap<>();
    private final AtomicInteger index = new AtomicInteger(0);

    public ru.job4j.forum.model.Post save(ru.job4j.forum.model.Post post) {
        if (post.getId() == 0) {
            post.setId(index.incrementAndGet());
            posts.put(post.getId(), post);
        } else {
            posts.replace(post.getId(), post);
        }
        return post;
    }

    public Collection<ru.job4j.forum.model.Post> findAll() {
        return posts.values();
    }

    public ru.job4j.forum.model.Post findById(int id) {
        return posts.get(id);
    }

    public void delete(int id) {
        posts.remove(id);
    }
}
