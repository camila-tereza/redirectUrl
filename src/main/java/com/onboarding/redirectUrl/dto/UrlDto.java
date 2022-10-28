package com.onboarding.redirectUrl.dto;

import com.onboarding.redirectUrl.model.Url;

public class UrlDto {

    private String name;
    private String link;

    public UrlDto(Url site){
        this.name = site.getName();
        this.link = site.getLink();
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
