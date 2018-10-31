package com.first.demo.Test;


import com.first.demo.Model.book;
import com.first.demo.Service.booksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class testmondodb {


      @Autowired
      private booksRepository boore;


      @Test
      public void test1() throws Exception {

            List<book> list  = new ArrayList<>();

           list =   boore.findAll();

            for (book book: list
                 ) {

               System.out.println(book.toString());

            }

      }


      @Test
      public void add(){

          Integer[] Authorsids = new Integer[2];

          Authorsids[0] = 1;
          Authorsids[1] = 2;

          book book = new book(2,"彷徨",3,"1969-02-06",Authorsids,3,"鲁迅",2,"汉","无",true);

          boore.save(book);

          System.out.println("插入数据成功");



      }













}
