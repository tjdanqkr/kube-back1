package com.example.demo1;


import java.util.UUID;

public record Board(
        UUID id,
        String title,
        String content
) {
}
