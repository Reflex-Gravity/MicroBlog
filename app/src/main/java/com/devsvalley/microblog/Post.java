package com.devsvalley.microblog;

import java.io.Serializable;

/**
 * Created by deepakbaliga on 13/12/16.
 */

public class Post implements Serializable {

    private String title;
    private String author;
    private String url;
    private String content;

    public Post(String title, String author, String url, String content) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.content = content;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
