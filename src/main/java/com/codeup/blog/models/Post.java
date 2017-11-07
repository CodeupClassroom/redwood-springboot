package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    // By default, String properties will be mapped to VARCHAR columns, if we want
    // a column of type TEXT, we can specify it like so:
    @Column(columnDefinition = "TEXT")
    private String body;

    public Post() {
    }

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
