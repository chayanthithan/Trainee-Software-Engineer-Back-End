package com.example.srilanka_cricket_service.repository;

import com.example.srilanka_cricket_service.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, String> {
}
