package com.onboarding.redirectUrl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String link;

    public Url(){
        link = "";
        name = "";
    }

    public Url(String name, String link){
        this.name = name;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }
}
