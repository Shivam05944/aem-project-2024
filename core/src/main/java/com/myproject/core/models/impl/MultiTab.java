package com.myproject.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MultiTab {
    @ValueMapValue
    public String fileReference;

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String subTitle;


    public String getFileReference() {
        return fileReference;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    @ValueMapValue
    public String description;


}
