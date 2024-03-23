package com.naszi.shop.book.bookshop;

import com.naszi.shop.book.bookshop.book.Book;
import com.naszi.shop.book.bookshop.book.BookRepository;
import com.naszi.shop.book.bookshop.user.Role;
import com.naszi.shop.book.bookshop.user.User;
import com.naszi.shop.book.bookshop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component

@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {


    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        var book1 = Book.builder()
                .author("Elly Conway")
                .title("Argylle")
                .imageurl("https://marvin.bline.hu/product_images/637/ID22-344909.JPG")
                .price(5100)
                .publisher("Maxim könyvkiadó")
                .yearofpublication(2024)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var book2 = Book.builder()
                .author("Liz Braswell")
                .title("Disney - A vén idő mesél - Sorsfordító történetek")
                .imageurl("https://marvin.bline.hu/product_images/509/ID22-344615.JPG")
                .price(4242)
                .publisher("Manó könyvek")
                .yearofpublication(2024)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var book3 = Book.builder()
                .author("Michel Montaud")
                .title("Fogaink - Szájon át a teljes egészségig!")
                .imageurl("https://marvin.bline.hu/product_images/1192/ID22-343227.JPG")
                .price(4242)
                .publisher("Success Development s.r.o.")
                .yearofpublication(2023)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var book4 = Book.builder()
                .author("Mary E. Pearson")
                .title("Tolvajok tánca")
                .imageurl("https://marvin.bline.hu/product_images/185/ID22-310668.JPG")
                .price(4741)
                .publisher("Gabo Kiadó")
                .yearofpublication(2023)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var book5 = Book.builder()
                .author("Amber Smith")
                .title("Amilyen akkor voltam")
                .imageurl("https://marvin.bline.hu/product_images/1382/ID22-345597.JPG")
                .price(3984)
                .publisher("Magnólia")
                .yearofpublication(2024)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var book6 = Book.builder()
                .author("Tahereh Mafi")
                .title("Ne felejts")
                .imageurl("https://marvin.bline.hu/product_images/676/ID22-343603.JPG")
                .price(3392)
                .publisher("Gabó kiadó")
                .yearofpublication(2023)
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                        " Sed ullamcorper ultrices accumsan. " +
                        "Donec quis nunc hendrerit, molestie erat a," +
                        " congue tellus. Sed eget consequat dui.")
                .build();
        var user = User.builder()
                .name("Szabolcs")
                .email("szabolcs@mail.hu")
                .password(passwordEncoder.encode("1234"))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
    }
}
