package com.bookstore.controllers;

import com.bookstore.dtos.BookDto;
import com.bookstore.entity.BookEntity;
import com.bookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookstore/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        var deleted = bookService.deleteBook(id);

        if (deleted) {
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return null;
    }
}
