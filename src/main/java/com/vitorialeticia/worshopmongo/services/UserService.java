package com.vitorialeticia.worshopmongo.services;

import com.vitorialeticia.worshopmongo.domain.User;
import com.vitorialeticia.worshopmongo.dto.UserDTO;
import com.vitorialeticia.worshopmongo.repository.UserRepository;
import com.vitorialeticia.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
       return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
   public User insert(User obj){
        return repo.insert(obj);
   }
   public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail())  ;
   }
}
