package com.first.demo.Model;


public class bookarticle {

    private  Integer _id ;

    private  String articletitle;

    private  String  articlewrittendate;

    private  String articlepublishdate;

    private  String  articlecontent ;

    private  String articlelanguage;

    private  Integer articletype ;

    private  Integer articlesource;

    private  Integer bookid;

    private  Integer mediatypeid;

    private  Integer articlepage;

    private  Integer articleorder;

    private   Boolean articlemultipages;

    private   Integer articletotalpages ;

    private  Integer articlepageorder ;

    private  Integer articlelastpartid ;

    private  Integer articlenextpartid;

    private  Boolean articlefiguretable;

    private  String articleimgname ;

    public bookarticle() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public String getArticlewrittendate() {
        return articlewrittendate;
    }

    public void setArticlewrittendate(String articlewrittendate) {
        this.articlewrittendate = articlewrittendate;
    }

    public String getArticlepublishdate() {
        return articlepublishdate;
    }

    public void setArticlepublishdate(String articlepublishdate) {
        this.articlepublishdate = articlepublishdate;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }

    public String getArticlelanguage() {
        return articlelanguage;
    }

    public void setArticlelanguage(String articlelanguage) {
        this.articlelanguage = articlelanguage;
    }

    public Integer getArticletype() {
        return articletype;
    }

    public void setArticletype(Integer articletype) {
        this.articletype = articletype;
    }

    public Integer getArticlesource() {
        return articlesource;
    }

    public void setArticlesource(Integer articlesource) {
        this.articlesource = articlesource;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getMediatypeid() {
        return mediatypeid;
    }

    public void setMediatypeid(Integer mediatypeid) {
        this.mediatypeid = mediatypeid;
    }

    public Integer getArticlepage() {
        return articlepage;
    }

    public void setArticlepage(Integer articlepage) {
        this.articlepage = articlepage;
    }

    public Integer getArticleorder() {
        return articleorder;
    }

    public void setArticleorder(Integer articleorder) {
        this.articleorder = articleorder;
    }

    public Boolean getArticlemultipages() {
        return articlemultipages;
    }

    public void setArticlemultipages(Boolean articlemultipages) {
        this.articlemultipages = articlemultipages;
    }

    public Integer getArticletotalpages() {
        return articletotalpages;
    }

    public void setArticletotalpages(Integer articletotalpages) {
        this.articletotalpages = articletotalpages;
    }

    public Integer getArticlepageorder() {
        return articlepageorder;
    }

    public void setArticlepageorder(Integer articlepageorder) {
        this.articlepageorder = articlepageorder;
    }

    public Integer getArticlelastpartid() {
        return articlelastpartid;
    }

    public void setArticlelastpartid(Integer articlelastpartid) {
        this.articlelastpartid = articlelastpartid;
    }

    public Integer getArticlenextpartid() {
        return articlenextpartid;
    }

    public void setArticlenextpartid(Integer articlenextpartid) {
        this.articlenextpartid = articlenextpartid;
    }

    public Boolean getArticlefiguretable() {
        return articlefiguretable;
    }

    public void setArticlefiguretable(Boolean articlefiguretable) {
        this.articlefiguretable = articlefiguretable;
    }

    public String getArticleimgname() {
        return articleimgname;
    }

    public void setArticleimgname(String articleimgname) {
        this.articleimgname = articleimgname;
    }

    @Override
    public String toString() {
        return "bookarticle{" +
                "_id=" + _id +
                ", articletitle='" + articletitle + '\'' +
                ", articlewrittendate='" + articlewrittendate + '\'' +
                ", articlepublishdate='" + articlepublishdate + '\'' +
                ", articlecontent='" + articlecontent + '\'' +
                ", articlelanguage='" + articlelanguage + '\'' +
                ", articletype=" + articletype +
                ", articlesource=" + articlesource +
                ", bookid=" + bookid +
                ", mediatypeid=" + mediatypeid +
                ", articlepage=" + articlepage +
                ", articleorder=" + articleorder +
                ", articlemultipages=" + articlemultipages +
                ", articletotalpages=" + articletotalpages +
                ", articlepageorder=" + articlepageorder +
                ", articlelastpartid=" + articlelastpartid +
                ", articlenextpartid=" + articlenextpartid +
                ", articlefiguretable=" + articlefiguretable +
                ", articleimgname='" + articleimgname + '\'' +
                '}';
    }
}
