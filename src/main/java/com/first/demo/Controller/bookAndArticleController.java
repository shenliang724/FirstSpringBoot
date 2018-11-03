package com.first.demo.Controller;


import com.first.demo.Model.book;
import com.first.demo.Model.bookarticle;
import com.first.demo.Service.articlesResposity;
import com.first.demo.Service.booksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/book")
public class bookAndArticleController {

      @Autowired
      private booksRepository booksResposity;

      @Autowired
       private articlesResposity  articlesResposity;

      @RequestMapping(value="/findArticleByBookId")
      public String findArticleByBookId(@RequestParam(value = "id") long id, Model model){

          System.out.println("程序开始运行-----");


          List<bookarticle> articleList = new ArrayList<>();



          List<bookarticle> list =   articlesResposity.findAll();

          for (bookarticle bookarticle :list
                  ) {

              if (bookarticle.getBookid()==id){

                  System.out.println(bookarticle.toString());

                  articleList.add(bookarticle);



              }


          }

          model.addAttribute("articleList",articleList);

          return  "Book/findbookByID";

      }





}
