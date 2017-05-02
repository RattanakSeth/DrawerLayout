package kh.edu.rupp.drawerlayout.datamodel;

/**
 * Created by rattanak on 4/25/17.
 */

public class Article {
    private String title;
    private String content;
    private String date;
    private String thumbnailUrl;
    private String imageUrl;
    private int size;

    //Create constructor

    public Article(String title, String content, String date, String thumbnailUrl, String imageUrl, int size) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.thumbnailUrl = thumbnailUrl;
        this.imageUrl = imageUrl;
        this.size = size;
    }

    public Article(String title, int size, String imageUrl) {
        this.title = title;
        this.size = size;
        this.imageUrl = imageUrl;
    }

//generate to seter and geter

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
