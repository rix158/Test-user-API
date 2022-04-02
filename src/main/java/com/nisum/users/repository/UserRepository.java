package com.nisum.users.repository;

import com.nisum.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT E.email FROM User E WHERE E.email = :email")
//    List<Long> findByEmail(@Param("email") String email);
    List <User> findByEmail(String email);
}

