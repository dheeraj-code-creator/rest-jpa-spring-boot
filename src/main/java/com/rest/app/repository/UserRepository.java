package com.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
