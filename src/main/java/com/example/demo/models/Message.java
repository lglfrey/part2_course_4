package com.example.demo.models;

import java.util.Date;

public class Message {
    public int idMessage;
    public String content;
    public String urlPhoto;
    public String timestamp;

    public Message(int idMessage, String content, String urlPhoto, String timestamp) {
        this.idMessage = idMessage;
        this.content = content;
        this.urlPhoto = urlPhoto;
        this.timestamp = timestamp;
    }

    public Message() {

    }

    public int getId() {
        return idMessage;
    }

    public void setId(int idMessage) {
        this.idMessage = idMessage;
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
