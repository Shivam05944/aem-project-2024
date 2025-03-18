package com.myproject.core.models.impl;

import com.myproject.core.models.ImageDescription;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
@Model(adaptables = {Resource.class},
        adapters = {ImageDescription.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageDescriptionImpl implements ImageDescription {

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String fileReference;

    @ValueMapValue
    public String description;

    @ValueMapValue
    public String label;

    @ValueMapValue
    public String registerLink;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getRegisterLink() {
        return registerLink;
    }
}
