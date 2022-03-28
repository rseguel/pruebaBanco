package cl.java.login.controller;

import cl.java.login.dto.Login;
import cl.java.login.dto.UserResponse;
import cl.java.login.mapper.UserMapper;
import cl.java.login.model.User;
import cl.java.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity crear(@RequestBody User employee){

        User created = userService.crear(employee);

        if(created==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No ha sido posible crear el usuario");
        }

        return new ResponseEntity(created,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    public ResponseEntity getById(@PathVariable int id){
        final User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        UserResponse userResponse = UserMapper.toResponse(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


}
