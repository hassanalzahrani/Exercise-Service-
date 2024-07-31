package com.example.execriseservice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {

        @NotNull(message = "id should not be null")
        private int id;
@NotEmpty(message = "title should not be empty")
@Size(min = 10,max = 100)
        private String title;
@NotEmpty(message = "author should not be empty")
@Size(min = 5,max = 20)
        private String author;
@NotEmpty(message = "content should not be empty")
@Size(min = 201,message = "content must be mpre than 200 characters")
        private String content;
@NotEmpty(message = "category should not be empty")
@Pattern(regexp = "^(sports|technology)$")
        private String category;
@NotEmpty(message = "imageUrl should not be empty")
        private String imageUrl;
@NotEmpty(message = "f")
@AssertFalse(message = "f")
        private boolean isPublished;
        private LocalDate publishDate;


}
