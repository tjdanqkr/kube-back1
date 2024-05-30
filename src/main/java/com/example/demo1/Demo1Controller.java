package com.example.demo1;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/demo1")
public class Demo1Controller {
    private final List<Board> boards;

    public Demo1Controller() {
        boards = new ArrayList<>();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping
    public List<Board> getBoards() {
        return boards;
    }
    @GetMapping("{id}")
    public Board getBoardById(@PathVariable("id") UUID id) {
        return boards.stream()
                .filter(board -> board.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Board save(@RequestBody BoardRequest request) {
        Board board = request.toEntity();
        boards.add(board);
        return board;
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        boards.removeIf(board -> board.id().equals(id));
    }

}
