package com.example.rezaul.newspaper;

public class Newspaper_Info {

    private int pic;
    private String name;
    private String link;

    public Newspaper_Info(int pic, String name, String link) {
        this.pic = pic;
        this.name = name;
        this.link = link;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
