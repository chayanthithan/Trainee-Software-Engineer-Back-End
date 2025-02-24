package com.example.User.Management.Microservice.repository;

import com.example.User.Management.Microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
