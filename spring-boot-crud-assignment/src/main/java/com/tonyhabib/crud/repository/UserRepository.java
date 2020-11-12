package com.tonyhabib.crud.repository;

import com.tonyhabib.crud.entity.Domain;
import com.tonyhabib.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query("Select substring(email_address,position('@' in email_address)+1) as domain, COUNT(*) FROM users Group by domain")
//    @Query("SELECT * FROM USER")
//    public List<User> findDomain();

}
