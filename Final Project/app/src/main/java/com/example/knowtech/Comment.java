package com.example.knowtech;

class Comment {
    public String commentID, PostID, comment, id, email, dateCreated;
    public User author;
    public Comment(User user, String id, String email, String commentID, String PostID, String comment, String dateCreated) {
        this.author = user;
        this.commentID = commentID;
        this.PostID = PostID;
        this.comment = comment;
        this.id = id;
        this.email = email;
        this.dateCreated = dateCreated;
    }
}