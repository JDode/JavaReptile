package com.github.JDode.JavaReptile.model;

import lombok.Data;

/**
 * Created by Ding on 2019/4/13 3:26 PM.
 *
 * @Description: 对应数据库T_R_01 & 对应被爬取的服务器的相应的数据模型
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */

public class Table01 {

    private int id;

    private String question;

    private String a;

    private String b;

    private String c;

    private String d;

    private byte ta;

    private String imageurl;

    private String bestanswer;

    private String bestanswerid;

    private byte type;

    private String sinaimg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public byte getTa() {
        return ta;
    }

    public void setTa(byte ta) {
        this.ta = ta;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBestanswer() {
        return bestanswer;
    }

    public void setBestanswer(String bestanswer) {
        this.bestanswer = bestanswer;
    }

    public String getBestanswerid() {
        return bestanswerid;
    }

    public void setBestanswerid(String bestanswerid) {
        this.bestanswerid = bestanswerid;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getSinaimg() {
        return sinaimg;
    }

    public void setSinaimg(String sinaimg) {
        this.sinaimg = sinaimg;
    }
}
