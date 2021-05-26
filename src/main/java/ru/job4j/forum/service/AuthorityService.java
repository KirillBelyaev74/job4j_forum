package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.service.repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
