package com.product.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Users;
import java.lang.String;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
   Optional<Users> findByEmailId(String emailid);
   
   Optional<Users> findByUserName(String username);
}
