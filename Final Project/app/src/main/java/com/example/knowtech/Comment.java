package com.example.knowtech;

class Comment {
    public String commentID, announcementID, comment, id, email, dateCreated;
    public Admin author;
    public Comment(Admin admin, String id, String email, String commentID, String announcementID, String comment, String dateCreated) {
        this.author = admin;
        this.commentID = commentID;
        this.announcementID = announcementID;
        this.comment = comment;
        this.id = id;
        this.email = email;
        this.dateCreated = dateCreated;
    }
}