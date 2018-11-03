package com.first.demo.Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class book implements Serializable {

    private int _id;

    private String bookname;

    private int bookpublisherid;

    private String bookpublishdate;

    private Integer[] bookAuthorsids;

    private int bookbehaviorid;

    private String bookcontributor;

    private int booktypeid;

    private String booklanguage;

    private String bookfuzhu;

    private boolean bookpublic;

    public book() {

    }

    public book(int _id, String bookname, int bookpublisherid, String bookpublishdate, Integer[] bookAuthorsids, int bookbehaviorid, String bookcontributor, int booktypeid, String booklanguage, String bookfuzhu, boolean bookpublic) {
        this._id = _id;
        this.bookname = bookname;
        this.bookpublisherid = bookpublisherid;
        this.bookpublishdate = bookpublishdate;
        this.bookAuthorsids = bookAuthorsids;
        this.bookbehaviorid = bookbehaviorid;
        this.bookcontributor = bookcontributor;
        this.booktypeid = booktypeid;
        this.booklanguage = booklanguage;
        this.bookfuzhu = bookfuzhu;
        this.bookpublic = bookpublic;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getBookpublisherid() {
        return bookpublisherid;
    }

    public void setBookpublisherid(int bookpublisherid) {
        this.bookpublisherid = bookpublisherid;
    }

    public String getBookpublishdate() {
        return bookpublishdate;
    }

    public void setBookpublishdate(String bookpublishdate) {
        this.bookpublishdate = bookpublishdate;
    }

    public Integer[] getBookAuthorsids() {
        return bookAuthorsids;
    }

    public void setBookAuthorsids(Integer[] bookAuthorsids) {
        this.bookAuthorsids = bookAuthorsids;
    }

    public int getBookbehaviorid() {
        return bookbehaviorid;
    }

    public void setBookbehaviorid(int bookbehaviorid) {
        this.bookbehaviorid = bookbehaviorid;
    }

    public String getBookcontributor() {
        return bookcontributor;
    }

    public void setBookcontributor(String bookcontributor) {
        this.bookcontributor = bookcontributor;
    }

    public int getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(int booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getBooklanguage() {
        return booklanguage;
    }

    public void setBooklanguage(String booklanguage) {
        this.booklanguage = booklanguage;
    }

    public String getBookfuzhu() {
        return bookfuzhu;
    }

    public void setBookfuzhu(String bookfuzhu) {
        this.bookfuzhu = bookfuzhu;
    }

    public boolean isBookpublic() {
        return bookpublic;
    }

    public void setBookpublic(boolean bookpublic) {
        this.bookpublic = bookpublic;
    }

    @Override
    public String toString() {
        return "book{" +
                "_id=" + _id +
                ", bookname='" + bookname + '\'' +
                ", bookpublisherid=" + bookpublisherid +
                ", bookpublishdate=" + bookpublishdate +
                ", bookAuthorsids=" + Arrays.toString(bookAuthorsids) +
                ", bookbehaviorid=" + bookbehaviorid +
                ", bookcontributor='" + bookcontributor + '\'' +
                ", booktypeid=" + booktypeid +
                ", booklanguage='" + booklanguage + '\'' +
                ", bookfuzhu='" + bookfuzhu + '\'' +
                ", bookpublic=" + bookpublic +
                '}';
    }
}
