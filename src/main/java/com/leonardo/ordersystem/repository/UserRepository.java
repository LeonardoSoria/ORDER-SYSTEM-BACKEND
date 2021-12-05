package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.username = :username AND u.password = :password")
    List<User> findUserByUsernameAndPassword(@Param("username") String username,
                                             @Param("password") String password);
}
