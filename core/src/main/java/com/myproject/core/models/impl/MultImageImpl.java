package com.myproject.core.models.impl;

import com.myproject.core.models.MultImage;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {Resource.class},
        adapters = {MultImage.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultImageImpl implements MultImage {
    @ChildResource
    public List<MultiForm> forms;

    @Override
    public List<MultiForm> getForm() {
        return forms;
    }

}
