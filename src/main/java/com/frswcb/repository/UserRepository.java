package com.frswcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frswcb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
