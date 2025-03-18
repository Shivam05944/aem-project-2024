package com.myproject.core.models.impl;


import com.myproject.core.models.Herobanner;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class}, adapters = {Herobanner.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroBannerImpl implements Herobanner {
    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
