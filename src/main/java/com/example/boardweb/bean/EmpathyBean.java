package com.example.boardweb.bean;

public class EmpathyBean {
    private int no;
    private int board_no;
    private int cnt_like;
    private int cnt_dislike;

    public EmpathyBean() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public int getCnt_like() {
        return cnt_like;
    }

    public void setCnt_like(int cnt_like) {
        this.cnt_like = cnt_like;
    }

    public int getCnt_dislike() {
        return cnt_dislike;
    }

    public void setCnt_dislike(int cnt_dislike) {
        this.cnt_dislike = cnt_dislike;
    }
}
