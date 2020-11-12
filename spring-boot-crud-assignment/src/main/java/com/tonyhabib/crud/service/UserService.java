package com.tonyhabib.crud.service;

import com.tonyhabib.crud.entity.Domain;
import com.tonyhabib.crud.entity.User;
import com.tonyhabib.crud.mapper.DomainMapper;
import com.tonyhabib.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;



    @Autowired
    JdbcTemplate jdbcTemplate;


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


    public List<Domain> listDomains() {

        String sql = "Select substring(email_address,position('@' in email_address)+1) as domain, COUNT(*) as count FROM users Group by domain";


        List<Domain> domains = jdbcTemplate.query(sql, new DomainMapper());

        return domains;
    }
}
