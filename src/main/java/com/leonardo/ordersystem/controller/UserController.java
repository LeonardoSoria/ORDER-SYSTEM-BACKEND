package com.leonardo.ordersystem.controller;

import com.leonardo.ordersystem.DTO.LoginDTO;
import com.leonardo.ordersystem.DTO.UserDTO;
import com.leonardo.ordersystem.entity.User;
import com.leonardo.ordersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO user) {
        return ok(userService.saveUser(user));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
        return ok(userService.login(loginDTO.getUsername(), loginDTO.getPassword()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ok(userService.updateUser(user));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ok(userService.getUsers());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable Long id) {
        return ok(userService.getUserById(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUsers(@PathVariable Long id) {
        return ok(userService.deleteUser(id));
    }
}
