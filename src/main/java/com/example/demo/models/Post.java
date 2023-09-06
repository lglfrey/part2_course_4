package com.example.demo.models;

import java.util.Date;

public class Post {
    public int idPost;
    public String content;
    public String urlPhoto;
    public String timestamp;

    public Post(int idPost, String content, String urlPhoto, String timestamp) {
        this.idPost = idPost;
        this.content = content;
        this.urlPhoto = urlPhoto;
        this.timestamp = timestamp;
    }

    public Post() {

    }

    public int getId() {
        return idPost;
    }

    public void setId(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
