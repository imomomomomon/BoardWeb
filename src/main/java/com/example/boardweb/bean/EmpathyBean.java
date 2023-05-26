package com.example.boardweb.bean;

public class EmpathyBean {
    private int no;
    private int board_no;
    private int cnt_like;
    private int cnt_dislike;
    private String arr_like;
    private String arr_dislike;

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

    public String getArr_like() {
        return arr_like;
    }

    public void setArr_like(String arr_like) {
        this.arr_like = arr_like;
    }

    public String getArr_dislike() {
        return arr_dislike;
    }

    public void setArr_dislike(String arr_dislike) {
        this.arr_dislike = arr_dislike;
    }

    @Override
    public String toString() {
        return "EmpathyBean{" +
                "no=" + no +
                ", board_no=" + board_no +
                ", cnt_like=" + cnt_like +
                ", cnt_dislike=" + cnt_dislike +
                ", arr_like='" + arr_like + '\'' +
                ", arr_dislike='" + arr_dislike + '\'' +
                '}';
    }
}
