package com.myproject.core.models.impl;

import com.myproject.core.models.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class},
        adapters = {Page.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageImpl implements Page {

    @ValueMapValue
    public String fileReference;

    @Override
    public String getFileReference() {
        return fileReference;
    }
}
