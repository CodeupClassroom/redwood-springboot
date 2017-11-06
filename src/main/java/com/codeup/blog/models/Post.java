package com.codeup.blog.models;

public class Post {
    private long id;
    private String title;
    private String body;

    // Use on the CREATE action
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    // use when the post is retrieved from the database
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
