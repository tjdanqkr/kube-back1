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
@RequiredArgsConstructor
public class Demo1Controller {
    private final BoardRepository boardRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }
    @GetMapping("{id}")
    public Board getBoardById(@PathVariable("id") UUID id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Board save(@RequestBody BoardRequest request) {

        return boardRepository.save(request.toEntity());
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        boardRepository.deleteById(id);
    }

}
