package com.tonyhabib.crud.controller;

import com.tonyhabib.crud.entity.Domain;
import com.tonyhabib.crud.entity.User;
import com.tonyhabib.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;


    //Create 1 User
    @PostMapping("/api/users")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }


    //Get All Users
    @GetMapping("/api/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    //Get User by its id
    @GetMapping("/api/users/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    //Update user
    @PutMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id)   {
        return service.updateProduct(user, id);
    }

    //Delete user by its id
    @DeleteMapping("/api/users/{id}")
    public String deleteUser (@PathVariable int id){
        return service.deleteUser(id);
    }

    @GetMapping("/api/domains")
    public List<Domain> listDomains(){
        return service.listDomains();
    }
}
