package com.example.demo1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository
    extends JpaRepository<Board, UUID> {
}
