package com.myproject.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiForm {
    @ValueMapValue
    public String fileReference;

    @ValueMapValue
    public String name;

    @ValueMapValue
    public String description;

    public String getFileReference() {
        return fileReference;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
