package com.app.controller;

import com.app.show.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.app.show.Book;
//import com.app.domain.Book;
import java.util.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;


@RestController
@RequestMapping("home")
public class HomeController {

    @Value("${spring.application.name}")
    public String appnames;
    List<Book> blist = new LinkedList<>();
    @GetMapping(path="/show")
    public String SayHello() {
        return "Hello using the Spring app: "+appnames;
    }

    @PostMapping(path="/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    //@CrossOrigin  //com.app.show.Book
    public ResponseEntity<com.app.domain.Book> createBook(@RequestBody Book book) {
          ObjectMapper mapper = new ObjectMapper();
       com.app.domain.Book bbbbk=new com.app.domain.Book();

         // Book bbk= book;
        Book bbk= book;
        System.out.println("Hello My Json Book: "+book.toString());
       /*com.app.domain.Book bbk= new com.app.domain.Book();
        bbk.setId(book.getId());
        bbk.setName(book.getName());
        bbk.setPrice(book.getPrice());
        System.out.println("Hello My Json Book: "+book.toString());*/
        com.app.domain.Book bk = mapper.convertValue(book, com.app.domain.Book.class);
        if(bbk.equals(bk)) {
            System.out.println("Yes they are equlas");
        }
          // Book book1 =new Book("VBC780", "System Testing", 9800);
             //this.blist.add(bk);
             System.out.println("Hello Save one Book: "+bk.toString());
        ResponseEntity<com.app.domain.Book> bookResponseEntity = new ResponseEntity<com.app.domain.Book>(bk, HttpStatus.CREATED);
        return  bookResponseEntity;
    }
    @GetMapping(path="/alls")
    public List<Book> getalls() {
        Book b1 =new Book("VBC780", "System Testing", 9800);
        Book b2 =new Book("VBH762", "Java Program", 89);
        com.app.domain.Book bks=new com.app.domain.Book("nbv8887", "Test data", 8800);
        ObjectMapper mapper = new ObjectMapper();
        com.app.show.Book bk = mapper.convertValue(bks, com.app.show.Book.class);
        this.blist.add(b1);
        this.blist.add(b2);
        this.blist.add(bk);
        //Book bk1=bk;
       //Book bbb=(Book)bk1;
      /*  if(bk instanceof Book) {
            System.out.println("Yes is same type");
        }*/
       /* this.blist.add(bk);
        int t1=0;
        int t2=20;
        int t=t2/t1;
        System.out.println("The Result: "+t);*/

        System.out.println("Yes is same type: the size: "+this.blist.size());
        return this.blist;
    }

    @PostMapping(path="/saveone", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
       /* ObjectMapper mapper = new ObjectMapper();
        Book book1 = new Book();
        Object value = mapper.readValue(food , javaObject);*/
        List<Food> list= new LinkedList<>();
        list.add(food);
        System.out.println("Hello Save one Book: "+food.toString());
        ResponseEntity<Food> bookResponseEntity = new ResponseEntity<Food>(food, HttpStatus.CREATED);
        return  bookResponseEntity;
    }
}
