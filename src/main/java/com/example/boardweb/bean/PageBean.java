package com.example.boardweb.bean;

public class PageBean {
    private int pageScale;
    private int currentPage;
    private int currentBlock;
    private int totalPage;
    private int startNode;
    private int endNode;
    private int startPage;
    private int endPage;
    public PageBean() {
    }

    public PageBean(int pageScale, int currentPage, int currentBlock, int totalPage, int startNode, int endNode, int startPage, int endPage) {
        this.pageScale = pageScale;
        this.currentPage = currentPage;
        this.currentBlock = currentBlock;
        this.totalPage = totalPage;
        this.startNode = startNode;
        this.endNode = endNode;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public void set(int currentPage, int currentBlock, int totalPage, int startNode, int endNode, int startPage, int endPage) {
        this.currentPage = currentPage;
        this.currentBlock = currentBlock;
        this.totalPage = totalPage;
        this.startNode = startNode;
        this.endNode = endNode;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public void setEndNode(int endNode) {
        this.endNode = endNode;
    }

    public int getPageScale() {
        return pageScale;
    }

    public void setPageScale(int pageScale) {
        this.pageScale = pageScale;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(int currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageScale=" + pageScale +
                ", currentPage=" + currentPage +
                ", currentBlock=" + currentBlock +
                ", totalPage=" + totalPage +
                ", startNode=" + startNode +
                ", endNode=" + endNode +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }
}
