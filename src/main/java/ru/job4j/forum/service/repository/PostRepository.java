package ru.job4j.forum.service.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    @Modifying
    @Override
    List<Post> findAll();
}
