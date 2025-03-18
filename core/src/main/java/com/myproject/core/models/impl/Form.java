package com.myproject.core.models.impl;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Form {
    @ValueMapValue
    public String fileReference;

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String subtitle;

    @ValueMapValue
    public String datetime;

    @ValueMapValue
    public String registerLink;

    public String getFileReference() {
        return fileReference;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getRegisterLink() {
        return registerLink;
    }

    public String getDescription() {
        return description;
    }

    @ValueMapValue
    private String description;

}
