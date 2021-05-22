package ru.job4j.forum.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PostServiceTest {

    private final PostService postService = new PostService();
    private Post one = new Post("one", "one");
    private Post two = new Post("two", "two");

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
        Collection<Post> posts = postService.findAll();
        assertThat(posts.size(), is(2));
    }

    @Test
    public void whenSavePostThenFindById() {
        Post result = postService.findById(one.getId());
        assertThat(result, is(one));
    }

    @Test
    public void whenSavePostThenDelete() {
        postService.delete(one.getId());
        Post result = postService.findById(one.getId());
        assertNull(result);
    }
}