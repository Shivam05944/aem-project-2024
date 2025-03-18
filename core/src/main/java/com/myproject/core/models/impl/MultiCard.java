package com.myproject.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MultiCard {

    @ValueMapValue
    public String imagePath;

    @ValueMapValue
    public String imageTitle;

    public String getImagePath() {
        return imagePath;
    }

    public String getImageTitle() {
        return imageTitle;
    }
}
