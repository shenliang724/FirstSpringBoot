package com.first.demo.Test;


import com.first.demo.Model.book;
import com.first.demo.Model.bookarticle;
import com.first.demo.ParseXml.parseTest;
import com.first.demo.Service.articlesResposity;
import com.first.demo.Service.booksRepository;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class testmondodb {


      @Autowired
      private booksRepository boore ;

       @Autowired
      private articlesResposity  artlresposity;

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

      @Test
    public void parseTest(){

          List<book> books = null;
          book book = null;
          String fileName = "D:\\DataTest\\books.xml";

            SAXBuilder saxBuilder = new SAXBuilder();
            try {
                Document document = null;
                try {
                    document = saxBuilder.build(new FileInputStream(fileName));
                } catch (JDOMException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //获取根节点bookstore
                Element rootElement = document.getRootElement();

                //获取根节点的子节点，返回子节点的数组
                List<Element> bookList = rootElement.getChildren();
                books = new ArrayList<book>();
                for (Element bookElement : bookList) {

//                System.out.println(bookElement.getName());

                    book = new book();
                    //获取bookElement的属性
                    List<Attribute> bookAttributes = bookElement.getAttributes();
                    for (Attribute attribute : bookAttributes) {

                        System.out.println(attribute.getName());
                        if (attribute.getName().equals("_id")) {
                            String id = attribute.getValue();
                            System.out.println(id);
                            book.set_id(Integer.parseInt(id));
                        }
                    }
                    //获取bookElement的子节点
                    List<Element> children = bookElement.getChildren();
                    for(Element child : children){

                        if(child.getName().equals("bookname")){
                            String name = child.getValue();
                            // System.out.println(name);
                            book.setBookname(name);
                        }else if(child.getName().equals("bookpublisherid")){
                            Integer bookpublisherid = Integer.parseInt(child.getValue());
                            book.setBookpublisherid(bookpublisherid);
                            //  System.out.println(bookpublisherid);
                        }else if(child.getName().equals("bookpublishdate")){
                            String bookpublishdate = child.getValue();
                            book.setBookpublishdate(bookpublishdate);
                        }else if(child.getName().equals("bookAuthorsids")){
                            String[] bookAuthorsids = child.getValue().split(",");

                            Integer[] bookAuthorsid = new Integer[bookAuthorsids.length];

                            for (int i = 0;i<bookAuthorsids.length;i++
                                    ) {

                                bookAuthorsid[i] = Integer.parseInt(bookAuthorsids[i]);
                                //   System.out.println(bookAuthorsid[i]);
                            }
                            book.setBookAuthorsids(bookAuthorsid);

                        }else if(child.getName().equals("bookbehaviorid")){
                            Integer bookbehaviorid = Integer.parseInt(child.getValue());
                            book.setBookbehaviorid(bookbehaviorid);
                            //  System.out.println(bookbehaviorid);

                        }else if(child.getName().equals("bookcontributor")){
                            String bookcontributor = child.getValue();
                            book.setBookcontributor(bookcontributor);

                        }else if(child.getName().equals("booktypeid")){
                            Integer booktypeid = Integer.parseInt(child.getValue());
                            book.setBooktypeid(booktypeid);
                            //     System.out.println(booktypeid);

                        }else if(child.getName().equals("booklanguage")){
                            String booklanguage = child.getValue();
                            book.setBooklanguage(booklanguage);
                        }else if(child.getName().equals("bookfuzhu")){
                            String bookfuzhu = child.getValue();
                            book.setBookfuzhu(bookfuzhu);
                            //   System.out.println(bookfuzhu);

                        }else if(child.getName().equals("bookpublic")){
                            boolean bookpublic = Boolean.valueOf(child.getValue());
                            book.setBookpublic(bookpublic);
                        }

                    }
                   System.out.println(book.toString());

                    books.add(book);
                    book = null;

                }

            } catch (Exception e) {

                e.printStackTrace();
            }

//
//        for (book book1:books
//                )
//        {System.out.println("开始保存数据----");
//            boore.save(book1);
//        }

   }





    public void addbooks(List<book> list){

        System.out.println("插入数据开始");

        System.out.println(list.size());



        for (book book:list
             )
        {
            System.out.println(book.toString());
            boore.save(book);
        }

        System.out.println("插入数据成功");



    }

    @Test
    public void addBookAndArticle(){


        List<book> books = null;

         List<bookarticle> articles = null;

         book book = null;

         bookarticle article = null;

        String fileName = "D:\\DataTest\\books.xml";
            SAXBuilder saxBuilder = new SAXBuilder();
            try {
                Document document = null;
                try {
                    document = saxBuilder.build(new FileInputStream(fileName));
                } catch (JDOMException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //获取根节点bookstore
                Element rootElement = document.getRootElement();

                //获取根节点的子节点，返回子节点的数组
                List<Element> bookList = rootElement.getChildren();
                books = new ArrayList<book>();                        // 装载书的数组集合
                articles = new ArrayList<bookarticle>();                  //装载文章的集合
                for (Element bookElement : bookList) {

                    System.out.println(bookElement.getName());
                    if (bookElement.getName().equalsIgnoreCase("book")) {
                        book = new book();
                        //获取bookElement的属性
                        List<Attribute> bookAttributes = bookElement.getAttributes();
                        for (Attribute attribute : bookAttributes) {

                            //    System.out.println(attribute.getName());
                            if (attribute.getName().equals("_id")) {
                                String id = attribute.getValue();
                                System.out.println(id);
                                book.set_id(Integer.parseInt(id));
                            }
                        }
                        //获取bookElement的子节点
                        List<Element> children = bookElement.getChildren();
                        for (Element child : children) {

                            if (child.getName().equals("bookname")) {
                                String name = child.getValue();
                                // System.out.println(name);
                                book.setBookname(name);
                            } else if (child.getName().equals("bookpublisherid")) {
                                Integer bookpublisherid = Integer.parseInt(child.getValue());
                                book.setBookpublisherid(bookpublisherid);
                                //  System.out.println(bookpublisherid);
                            } else if (child.getName().equals("bookpublishdate")) {
                                String bookpublishdate = child.getValue();
                                book.setBookpublishdate(bookpublishdate);
                            } else if (child.getName().equals("bookAuthorsids")) {
                                String[] bookAuthorsids = child.getValue().split(",");

                                Integer[] bookAuthorsid = new Integer[bookAuthorsids.length];

                                for (int i = 0; i < bookAuthorsids.length; i++
                                        ) {

                                    bookAuthorsid[i] = Integer.parseInt(bookAuthorsids[i]);
                                    //   System.out.println(bookAuthorsid[i]);
                                }
                                book.setBookAuthorsids(bookAuthorsid);

                            } else if (child.getName().equals("bookbehaviorid")) {
                                Integer bookbehaviorid = Integer.parseInt(child.getValue());
                                book.setBookbehaviorid(bookbehaviorid);
                                //  System.out.println(bookbehaviorid);

                            } else if (child.getName().equals("bookcontributor")) {
                                String bookcontributor = child.getValue();
                                book.setBookcontributor(bookcontributor);

                            } else if (child.getName().equals("booktypeid")) {
                                Integer booktypeid = Integer.parseInt(child.getValue());
                                book.setBooktypeid(booktypeid);
                                //     System.out.println(booktypeid);

                            } else if (child.getName().equals("booklanguage")) {
                                String booklanguage = child.getValue();
                                book.setBooklanguage(booklanguage);
                            } else if (child.getName().equals("bookfuzhu")) {
                                String bookfuzhu = child.getValue();
                                book.setBookfuzhu(bookfuzhu);
                                //   System.out.println(bookfuzhu);

                            } else if (child.getName().equals("bookpublic")) {

                                boolean bookpublic = Boolean.valueOf(child.getValue());
                                book.setBookpublic(bookpublic);

                            }

                        }

                        books.add(book);

                        book = null;

                    } else if (bookElement.getName().equalsIgnoreCase("article")) {

                        article = new bookarticle();
                        //获取bookElement的属性
                        List<Attribute> bookAttributes = bookElement.getAttributes();
                        for (Attribute attribute : bookAttributes) {

                            if (attribute.getName().equals("_id")) {
                                String id = attribute.getValue();
                                System.out.println(id);
                                article.set_id(Integer.parseInt(id));
                            }
                        }
                        //获取bookElement的子节点
                        List<Element> children = bookElement.getChildren();

                        for (Element child : children) {

                            if (child.getName().equals("articletitle")) {
                                String title = child.getValue();
                                article.setArticletitle(title);

                            } else if (child.getName().equals("articlewrittendate")) {

                                String articlewrittendate = child.getValue();

                                article.setArticlewrittendate(articlewrittendate);

                            } else if (child.getName().equals("articlepublishdate")) {

                                String articlepublishdate = child.getValue();

                                article.setArticlepublishdate(articlepublishdate);

                            } else if (child.getName().equals("articlecontent")) {

                                String articlecontent = child.getValue();

                                article.setArticlecontent(articlecontent);

                            } else if (child.getName().equals("articlelanguage")) {

                                String articlelanguage = child.getValue();
                                article.setArticlelanguage(articlelanguage);

                            } else if (child.getName().equals("articletype")) {
                                Integer articletype = Integer.parseInt(child.getValue());
                                article.setArticletype(articletype);
                                //     System.out.println(booktypeid);

                            } else if (child.getName().equals("articlesource")) {

                                Integer articlesource = Integer.parseInt(child.getValue());
                                article.setArticlesource(articlesource);

                            } else if (child.getName().equals("bookid")) {

                                Integer bookid = Integer.parseInt(child.getValue());
                                article.setBookid(bookid);

                            }else if (child.getName().equals("mediatypeid")) {

                                Integer mediatypeid = Integer.parseInt(child.getValue());
                                article.setMediatypeid(mediatypeid);

                            } else if (child.getName().equals("articlepage")) {

                                Integer articlepage = Integer.parseInt(child.getValue());
                                article.setArticlepage(articlepage);

                            } else if (child.getName().equals("articlepage")) {

                                Integer articlepage = Integer.parseInt(child.getValue());
                                article.setArticlepage(articlepage);

                            } else if (child.getName().equals("articleorder")) {

                                Integer articleorder = Integer.parseInt(child.getValue());
                                article.setArticleorder(articleorder);

                            } else if (child.getName().equals("articlemultipages")) {

                                Boolean articlemultipages = Boolean.valueOf(child.getValue());
                                article.setArticlemultipages(articlemultipages);

                            } else if (child.getName().equals("articletotalpages")) {

                                Integer articletotalpages = Integer.parseInt(child.getValue());
                                article.setArticletotalpages(articletotalpages);

                            } else if (child.getName().equals("articlepageorder")) {

                                Integer articlepageorder = Integer.parseInt(child.getValue());
                                article.setArticlepageorder(articlepageorder);

                            } else if (child.getName().equals("articlelastpartid")) {

                                Integer articlelastpartid = Integer.parseInt(child.getValue());
                                article.setArticlelastpartid(articlelastpartid);

                            } else if (child.getName().equals("articlenextpartid")) {

                                Integer articlenextpartid = Integer.parseInt(child.getValue());
                                article.setArticlenextpartid(articlenextpartid);

                            } else if (child.getName().equals("articlefiguretable")) {

                                Boolean articlefiguretable = Boolean.valueOf(child.getValue());
                                article.setArticlefiguretable(articlefiguretable);

                            } else if (child.getName().equals("articleimgname")) {
                                String articleimgname = child.getValue();
                                article.setArticleimgname(articleimgname);
                            }

                        }

                        articles.add(article);

                        article = null;

                    }


                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            for (book book2 : books) {

                boore.save(book2);

                System.out.println(book2);
            }

            for (bookarticle article2 : articles) {

                artlresposity.save(article2);

                System.out.println(article2);

            }


      }








    }

















