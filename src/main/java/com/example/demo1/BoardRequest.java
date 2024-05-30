package com.example.demo1;


import java.util.UUID;

public record BoardRequest(

        String title,
        String content
) {
    public Board toEntity() {
        System.out.println(this);
        return new Board(UUID.randomUUID(), title, content);
    }
}
