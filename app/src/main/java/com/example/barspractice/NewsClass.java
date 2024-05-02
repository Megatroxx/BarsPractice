package com.example.barspractice;

public class NewsClass {

    protected int image;
    protected String header;
    protected String time;

    public NewsClass(int image, String header, String time) {
        this.image = image;
        this.header = header;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
