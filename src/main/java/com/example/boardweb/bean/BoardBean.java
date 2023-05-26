package com.example.boardweb.bean;

public class BoardBean {
    private int no;
    private String category;
    private String writer;
    private String title;
    private String contents;
    private String filename;
    private String regdate;
    private int parent_no;
    private int hit;

    public BoardBean() {
    }

    public BoardBean(String category, String writer, String title, String contents, String filename) {
        this.category = category;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.filename = filename;
    }

    public BoardBean(int no, String category, String writer,String title, String contents, String filename, String regdate, int parent_no, int hit) {
        this.no = no;
        this.category = category;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.filename = filename;
        this.regdate = regdate;
        this.parent_no = parent_no;
        this.hit = hit;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getParent_no() {
        return parent_no;
    }

    public void setParent_no(int parent_no) {
        this.parent_no = parent_no;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "BoardBean{" +
                "category='" + category + '\'' +
                ", writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
