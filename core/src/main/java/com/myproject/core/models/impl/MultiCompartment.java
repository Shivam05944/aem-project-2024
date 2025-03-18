package com.myproject.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MultiCompartment {
    @ValueMapValue
    public String fileReference;

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String subTitle;

    @ValueMapValue
    public String description;

    @ValueMapValue
    public String label;

    @ValueMapValue
    public String registerLink;

    public String getFileReference() {
        return fileReference;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getRegisterLink() {
        return registerLink;
    }
}
