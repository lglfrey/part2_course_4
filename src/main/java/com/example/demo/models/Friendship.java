package com.example.demo.models;

public class Friendship {
    public int idFriendship;
    public String username;
    public String urlPhoto;
    public String status;

    public Friendship(int idFriendship, String username, String urlPhoto, String status) {
        this.idFriendship = idFriendship;
        this.username = username;
        this.urlPhoto = urlPhoto;
        this.status = status;
    }

    public Friendship() {

    }

    public int getId() {
        return idFriendship;
    }

    public void setId(int idFriendship) {
        this.idFriendship = idFriendship;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
