package org.example;

import java.util.Date;

public class Comment {
    int id;
    String content;
    User author;
    Date creationDate;

    public Comment(int id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
