package com.mongod.mongow9.controller;

import com.mongod.mongow9.model.Author;
import com.mongod.mongow9.model.Book;
import com.mongod.mongow9.model.Price;
import com.mongod.mongow9.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/save")
    public String createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "todo esta bien";
    }

    @PostMapping("/save2")
    public String createBook2(@RequestBody Author author) {
        bookRepository.save(author);
        return "todo esta bien";
    }

    @GetMapping("/list1")
    public List<Book> listBooks1(@RequestBody Price price){
        return bookRepository.findBookByPriceGreaterThan(price.getPrice());
    }

    @GetMapping("/list2")
    public List<Book> listBooks2(@RequestBody Price price){
        return bookRepository.findBookByPriceGreaterThan2(price.getPrice());
    }

    @GetMapping("/list3")
    public List<Book> listBook3(@RequestBody Price price){
        return bookRepository.findBookByPriceGreaterThan3(price.getPrice());
    }

    @GetMapping("/list4")
    public List<Book> listBook4(@RequestBody Price price){
        return bookRepository.findBookByPriceGreaterThan4(price.getPrice());
    }

    @GetMapping("/list5")
    public List<Book> listBook5(@RequestBody Price price){
        return bookRepository.findBookByPriceGreaterThan5(price.getPrice());
    }
}
