package com.mongod.mongow9.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "books")
public class Book {

    @MongoId
    private ObjectId id;

    private String author;
    @Field(name = "title_book")
    private String title;
    private Double price;
    private LocalDate publicationDate;
}
