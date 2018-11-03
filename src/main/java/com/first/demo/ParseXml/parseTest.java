package com.first.demo.ParseXml;




import com.first.demo.Model.bookarticle;
import com.first.demo.Test.testmondodb;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.first.demo.Model.book;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

public class parseTest {


    private List<book> books = null;

    private List<bookarticle> articles = null;

    private book book = null;

    private bookarticle article = null;

    public void getBooks(String fileName) {
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

                        } else if (child.getName().equals("mediatypeid")) {

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

        for (book book : books) {
            System.out.println(book);
        }

        for (bookarticle article : articles) {
            System.out.println(article);
        }

    }

    public static void main(String[] args) {


        String fileName = "D:\\DataTest\\books.xml";

        parseTest pt = new parseTest();

        pt.getBooks(fileName);

    }

}