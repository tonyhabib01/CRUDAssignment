package com.tonyhabib.crud.service;

import com.tonyhabib.crud.entity.User;
import com.tonyhabib.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //POST: "/api/users/
    public User saveUser (User user){
        return repository.save(user);
    }

    //GET: "/api/users/"
    public List<User> getUsers (){
        return repository.findAll();
    }

    //GET: "/api/users/1"
    public User getUserById (int id){
        return repository.findById(id).orElse(null);
    }

    //DELETE: "/api/users/1"
    public String deleteUser(int id){
        repository.deleteById(id);
        return "User Id " + id + " Deleted!!";
    }

    //PUT: "/api/users"
    public User updateProduct (User user, int id){
        User userInDb = repository.findById(id).orElse(null);
        userInDb.setFirstName(user.getFirstName());
        userInDb.setLastName(user.getLastName());
        userInDb.setEmailAddress(user.getEmailAddress());

        return repository.save(userInDb);
    }

}
