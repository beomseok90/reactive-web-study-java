package com.beom.reactive.section9;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Book {
    private String isbn;
    private String bookName;
    private String author;
}