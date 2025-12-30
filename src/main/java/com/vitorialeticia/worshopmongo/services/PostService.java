package com.vitorialeticia.worshopmongo.services;
import com.vitorialeticia.worshopmongo.domain.Post;
import com.vitorialeticia.worshopmongo.repository.PostRepository;
import com.vitorialeticia.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
