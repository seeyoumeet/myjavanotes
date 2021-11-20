package com.seeyoumeet.web.SpringJPA.entity;

/**
 * @Classname PageQuery
 * @Description ：...
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
public class PageQuery {

    private int page;
    private int size;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

}
