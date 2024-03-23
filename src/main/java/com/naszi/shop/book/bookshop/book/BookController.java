package com.naszi.shop.book.bookshop.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/public/book/all")
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("/rest/book/add")
    public ResponseEntity<Book> addBook(
            @RequestBody BookRequest request
    ) {
        bookService.saveBook(request);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/rest/book/update/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable("id") Integer id,
            @RequestBody BookRequest request
    ) {
        bookService.updateBook(id, request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/rest/book/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
