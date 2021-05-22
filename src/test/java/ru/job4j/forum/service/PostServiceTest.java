package ru.job4j.forum.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.forum.service.memory.PostMemory;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PostServiceTest {

    private final PostMemory postService = new PostMemory();
    private ru.job4j.forum.model.Post one = new ru.job4j.forum.model.Post("one", "one");
    private ru.job4j.forum.model.Post two = new ru.job4j.forum.model.Post("two", "two");

    @Before
    public void start() {
        one = postService.save(one);
        two = postService.save(two);
    }

    @After
    public void finish() {
        postService.delete(one.getId());
        postService.delete(two.getId());
    }

    @Test
    public void whenSavePostThenFindAll() {
        Collection<ru.job4j.forum.model.Post> posts = postService.findAll();
        assertThat(posts.size(), is(2));
    }

    @Test
    public void whenSavePostThenFindById() {
        ru.job4j.forum.model.Post result = postService.findById(one.getId());
        assertThat(result, is(one));
    }

    @Test
    public void whenSavePostThenDelete() {
        postService.delete(one.getId());
        ru.job4j.forum.model.Post result = postService.findById(one.getId());
        assertNull(result);
    }
}