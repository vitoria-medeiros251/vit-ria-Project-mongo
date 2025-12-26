package com.vitorialeticia.worshopmongo.resources;
import com.vitorialeticia.worshopmongo.domain.User;
import com.vitorialeticia.worshopmongo.dto.UserDTO;
import com.vitorialeticia.worshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping( "/users")
public class UserResource {

     @Autowired
     private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findALL(){
        List<User> list = service.findAll();
        List<UserDTO> ListDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO>  findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO  objDto){
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}