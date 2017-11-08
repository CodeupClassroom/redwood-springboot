package com.codeup.blog.models;

import javax.persistence.*;

@Entity
// Using camel case transforms the name into name_table
@Table(name = "adImages")
public class AdImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn (name = "ad_id")
    private Ad ad;

    public AdImage() {
    }

    public AdImage(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
