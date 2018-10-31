package com.first.demo.Controller;


import com.first.demo.Model.book;
import com.first.demo.Service.booksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class bookController {



    @Autowired
    private booksRepository boore;

    @RequestMapping("/findbook")
    public List<book> findAllBook(){

        List<book> list  = new ArrayList<>();

        list =  boore.findAll();


        return list;


    }

    @RequestMapping("/findbookById")
    public book findBookById(@RequestParam(value = "id")int id ){

        book  SpecialBook =null;

        List<book> list  = new ArrayList<>();

        list =  boore.findAll();

        for (book book:list) {

            if (book.get_id()==id){

                SpecialBook = book;

            }

        }

        if (SpecialBook == null){

            return null;

        }else {

            return SpecialBook;
        }





    }



    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }




}
