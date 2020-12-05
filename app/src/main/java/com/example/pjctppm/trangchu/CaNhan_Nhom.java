package com.example.pjctppm.trangchu;

public class CaNhan_Nhom {

    private String name_work;
    private int img_work;

    public CaNhan_Nhom() {
    }

    public CaNhan_Nhom(String name_work, int img_work) {
        this.name_work = name_work;
        this.img_work = img_work;
    }

    public String getName_work() {
        return name_work;
    }

    public void setName_work(String name_work) {
        this.name_work = name_work;
    }

    public int getImg_work() {
        return img_work;
    }

    public void setImg_work(int img_work) {
        this.img_work = img_work;
    }
}
