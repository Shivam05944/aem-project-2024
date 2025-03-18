package com.myproject.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiPath {

    @ValueMapValue
    public String text;

    @ValueMapValue
    public List<String> files;

    @ValueMapValue
    public String description;

    @ValueMapValue
    public String registerLink;

    @ValueMapValue
    public String label;

    public String getText() {
        return text;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    public String getRegisterLink() {
        return registerLink;
    }

    public String getLabel() {
        return label;
    }
}
