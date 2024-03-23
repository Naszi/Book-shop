package com.naszi.shop.book.bookshop.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {
    private Integer id;
    private String author;
    private String title;
    private String imageurl;
    private int price;
    private int yearofpublication;
    private String publisher;
    private String description;
}
