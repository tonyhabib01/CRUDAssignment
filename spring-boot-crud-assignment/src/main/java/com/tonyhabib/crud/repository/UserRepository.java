package com.tonyhabib.crud.repository;

import com.tonyhabib.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
