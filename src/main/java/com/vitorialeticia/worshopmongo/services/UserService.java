package com.vitorialeticia.worshopmongo.services;

import com.vitorialeticia.worshopmongo.domain.User;
import com.vitorialeticia.worshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
       return repo.findAll();
    }
}
