package com.example.springdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksDTO {
    private String title;
    private Long authorId;
    private String publicationDate;
    private int numberOfCopies;

}
