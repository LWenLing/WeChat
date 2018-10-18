package com.example.simpleton.wechat;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Serializable {
    private int imgId;
    private String name;
    private Date enterDate;

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "imgId=" + imgId +
                ", name='" + name + '\'' +
                ", enterDate=" + enterDate +
                '}';
    }

    public Animal(int imgId,String name,Date enterDate) {
        this.enterDate=enterDate;
        this.name=name;
        this.imgId=imgId;
    }
}
