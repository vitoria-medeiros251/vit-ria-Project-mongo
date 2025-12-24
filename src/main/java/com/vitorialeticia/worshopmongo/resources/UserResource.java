package com.vitorialeticia.worshopmongo.resources;
import com.vitorialeticia.worshopmongo.domain.User;
import com.vitorialeticia.worshopmongo.dto.UserDTO;
import com.vitorialeticia.worshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}