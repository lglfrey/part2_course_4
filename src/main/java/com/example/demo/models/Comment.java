package com.example.demo.models;

public class Comment {
    public int idComment;
    public String content;
    public String urlPhoto;
    public String timestamp;

    public Comment(int idComment, String content, String urlPhoto, String timestamp) {
        this.idComment = idComment;
        this.content = content;
        this.urlPhoto = urlPhoto;
        this.timestamp = timestamp;
    }

    public Comment() {

    }

    public int getId() {
        return idComment;
    }

    public void setId(int idComment) {
        this.idComment = idComment;
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
