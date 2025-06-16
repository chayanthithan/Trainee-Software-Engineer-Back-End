package com.example.spring.security.demo.repository;

import com.example.spring.security.demo.entity.MatrimonyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrimonyRepo extends JpaRepository<MatrimonyDetails,Long> {
}
