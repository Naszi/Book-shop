package com.naszi.shop.book.bookshop.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void saveBook(BookRequest request) {
        var book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .title(request.getTitle())
                .imageurl(request.getImageurl())
                .price(request.getPrice())
                .yearofpublication(request.getYearofpublication())
                .publisher(request.getPublisher())
                .description(request.getDescription())
                .build();
        bookRepository.save(book);
    }

    public void updateBook(Integer id, BookRequest request) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAuthor(request.getAuthor());
            book.setDescription(request.getDescription());
            book.setPrice(request.getPrice());
            book.setImageurl(request.getImageurl());
            book.setPublisher(request.getPublisher());
            book.setTitle(request.getTitle());
            book.setYearofpublication(request.getYearofpublication());
            bookRepository.save(book);
        }
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
