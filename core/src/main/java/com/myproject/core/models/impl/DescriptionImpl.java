package com.myproject.core.models.impl;

import com.myproject.core.models.Description;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {Resource.class},
        adapters = {Description.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DescriptionImpl implements Description {
    protected static final String RESOURCE_TYPE = "mysite/component/description";

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String subtitle;

    @ValueMapValue
    private String datetime;

    @ValueMapValue
    private String registerLink;

    @ValueMapValue
    private String description;

    @ChildResource
    public List<Form> forms;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getDatetime() {
        return datetime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getRegisterLink() {
        return registerLink;
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public List<Form> getForm() {
        return forms;
    }
}
