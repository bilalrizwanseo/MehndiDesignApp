package com.example.mehndidesignapp.Model;

public class MehndiImages {

    private String category, pid, image, date, time;

    public MehndiImages() {
    }

    public MehndiImages(String category, String pid, String image, String date, String time) {
        this.category = category;
        this.pid = pid;
        this.image = image;
        this.date = date;
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
