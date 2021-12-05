package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    @Query("SELECT a " +
            "FROM Avatar a " +
            "JOIN FETCH a.face " +
            "JOIN FETCH a.eye " +
            "JOIN FETCH a.nose " +
            "JOIN FETCH a.mouth " +
            "JOIN FETCH a.mustache " +
            "JOIN FETCH a.hat " +
            "JOIN FETCH a.user " +
            "WHERE a.user.id = :userId")
    List<Avatar> findAvatarByUserId(@Param("userId") Long userId);
}
